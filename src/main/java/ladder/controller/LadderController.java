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
        final Players players = readPlayers(new Retry(5));
        final Prizes prizes = readPrizes(new Retry(5), players);
        final Height height = readHeight(new Retry(5));
        final Ladder ladder = Ladder.of(new RandomDirectionGenerator(), players, height);
        outputView.printLadderGame(players, ladder, prizes);
        final Result result = Result.of(players, ladder, prizes);
        final String target = readTarget(new Retry(5), result);
        printResult(result, target);
    }

    private Players readPlayers(final Retry retry) {
        checkCount(retry);
        final Optional<Players> players = generatePlayers(inputView.readPlayerNames());
        if (players.isEmpty()) {
            retry.decrease();
            return readPlayers(retry);
        }
        return players.get();
    }

    private void checkCount(final Retry retry) {
        if (!retry.isPossible()) {
            throw new IllegalStateException("재입력 횟수를 초과하였습니다.");
        }
    }

    private Optional<Players> generatePlayers(final List<String> playerNames) {
        try {
            return Optional.of(Players.from(playerNames));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
        return Optional.empty();
    }

    private Prizes readPrizes(final Retry retry, final Players players) {
        checkCount(retry);
        final Optional<Prizes> prizes = generatePrizes(inputView.readPrizeNames(), players);
        if (prizes.isEmpty()) {
            retry.decrease();
            return readPrizes(retry, players);
        }
        return prizes.get();
    }

    private Optional<Prizes> generatePrizes(final List<String> prizeNames, final Players players) {
        try {
            final Prizes prizes = Prizes.from(prizeNames);
            validateSameSize(players, prizes);
            return Optional.of(prizes);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
        return Optional.empty();
    }

    private void validateSameSize(final Players players, final Prizes prizes) {
        if (players.size() != prizes.size()) {
            throw new IllegalArgumentException(
                    "실행 결과 개수는 플레이어 수와 동일해야 합니다. 플레이어 수: " + players.size() + ", 실행 결과 개수: " + prizes.size());
        }
    }

    private Height readHeight(final Retry retry) {
        checkCount(retry);
        final Optional<Height> height = generateHeight();
        if (height.isEmpty()) {
            retry.decrease();
            return readHeight(retry);
        }
        return height.get();
    }

    private Optional<Height> generateHeight() {
        try {
            final int height = inputView.readHeight();
            return Optional.of(new Height(height));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
        return Optional.empty();
    }

    private String readTarget(final Retry retry, final Result result) {
        checkCount(retry);
        final Optional<String> target = generateTarget(inputView.readTarget(), result);
        if (target.isEmpty()) {
            retry.decrease();
            return readTarget(retry, result);
        }
        return target.get();
    }

    private Optional<String> generateTarget(final String target, final Result result) {
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
