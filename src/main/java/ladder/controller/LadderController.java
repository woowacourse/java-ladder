package ladder.controller;

import java.util.List;
import java.util.Optional;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderResult;
import ladder.domain.Players;
import ladder.domain.Prizes;
import ladder.domain.Retry;
import ladder.util.generator.RandomDirectionGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private static final String ALL_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final Retry retry;

    public LadderController(final InputView inputView, final OutputView outputView, final Retry retry) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.retry = retry;
    }

    public void run() {
        final Players players = createPlayers(retry.renew());
        final Prizes prizes = createPrizes(retry.renew(), players);
        final Height height = createHeight(retry.renew());
        final Ladder ladder = Ladder.of(new RandomDirectionGenerator(), players, height);
        outputView.printLadderGame(players, ladder, prizes);
        final LadderGame ladderGame = new LadderGame(players, ladder, prizes);
        final LadderResult ladderResult = ladderGame.getResult();
        printResult(ladderResult);
    }

    private Players createPlayers(final Retry retry) {
        final Optional<Players> players = readPlayers();
        if (players.isEmpty()) {
            retry.decrease();
            return createPlayers(retry);
        }
        return players.get();
    }

    private Optional<Players> readPlayers() {
        try {
            final List<String> playerNames = inputView.readPlayerNames();
            return Optional.of(Players.from(playerNames));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
        return Optional.empty();
    }

    private Prizes createPrizes(final Retry retry, final Players players) {
        final Optional<Prizes> prizes = readPrizes(players);
        if (prizes.isEmpty()) {
            retry.decrease();
            return createPrizes(retry, players);
        }
        return prizes.get();
    }

    private Optional<Prizes> readPrizes(final Players players) {
        try {
            final List<String> prizeNames = inputView.readPrizeNames();
            return Optional.of(Prizes.from(prizeNames, players));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
        return Optional.empty();
    }

    private Height createHeight(final Retry retry) {
        final Optional<Height> height = readHeight();
        if (height.isEmpty()) {
            retry.decrease();
            return createHeight(retry);
        }
        return height.get();
    }

    private Optional<Height> readHeight() {
        try {
            final int height = inputView.readHeight();
            return Optional.of(new Height(height));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
        return Optional.empty();
    }

    private String createTarget(final Retry retry, final LadderResult ladderResult) {
        final Optional<String> target = readTarget(ladderResult);
        if (target.isEmpty()) {
            retry.decrease();
            return createTarget(retry, ladderResult);
        }
        return target.get();
    }

    private Optional<String> readTarget(final LadderResult ladderResult) {
        final String target = inputView.readTarget();
        if (target.equals(ALL_COMMAND) || ladderResult.exist(target)) {
            return Optional.of(target);
        }
        outputView.printErrorMessage("결과를 확인할 수 없는 대상입니다. 존재하는 대상: " + ladderResult.getValue().keySet());
        return Optional.empty();
    }

    private void printResult(final LadderResult ladderResult) {
        final String target = createTarget(new Retry(5), ladderResult);
        if (target.equals(ALL_COMMAND)) {
            outputView.printResult(ladderResult);
            return;
        }
        outputView.printResult(ladderResult.extract(target));
    }
}
