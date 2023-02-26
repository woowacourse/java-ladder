package ladder.controller;

import java.util.List;
import java.util.Optional;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Prizes;
import ladder.domain.Result;
import ladder.domain.Retry;
import ladder.domain.generator.RandomDirectionGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private static final String ALL_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Players players = createPlayers(new Retry(5));
        final Prizes prizes = createPrizes(new Retry(5), players);
        final Height height = createHeight(new Retry(5));
        final Ladder ladder = Ladder.of(new RandomDirectionGenerator(), players, height);
        outputView.printLadderGame(players, ladder, prizes);
        final Result result = Result.of(players, ladder, prizes);
        final String target = createTarget(new Retry(5), result);
        printResult(result, target);
    }

    private Players createPlayers(final Retry retry) {
        checkCount(retry);
        final Optional<Players> players = readPlayers();
        if (players.isEmpty()) {
            retry.decrease();
            return createPlayers(retry);
        }
        return players.get();
    }

    private void checkCount(final Retry retry) {
        if (!retry.isPossible()) {
            throw new IllegalStateException("재입력 횟수를 초과하였습니다.");
        }
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
        checkCount(retry);
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
        checkCount(retry);
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

    private String createTarget(final Retry retry, final Result result) {
        checkCount(retry);
        final Optional<String> target = readTarget(result);
        if (target.isEmpty()) {
            retry.decrease();
            return createTarget(retry, result);
        }
        return target.get();
    }

    private Optional<String> readTarget(final Result result) {
        final String target = inputView.readTarget();
        if (target.equals(ALL_COMMAND) || result.exist(target)) {
            return Optional.of(target);
        }
        outputView.printErrorMessage("결과를 확인할 수 없는 대상입니다. 존재하는 대상: " + result.getValue().keySet());
        return Optional.empty();
    }

    private void printResult(final Result result, final String target) {
        if (target.equals(ALL_COMMAND)) {
            outputView.printResult(result);
            return;
        }
        outputView.printResult(result.extract(target));
    }
}
