package laddergame.controller;

import laddergame.domain.ladder.ConnectionStrategy;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderGame;
import laddergame.domain.player.Name;
import laddergame.domain.player.Names;
import laddergame.domain.player.Players;
import laddergame.domain.prize.Prizes;
import laddergame.domain.prize.Result;
import laddergame.domain.prize.Results;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class GameController {

    private static final Name END_SIGNAL = new Name("end");

    private final Names names;
    private final Prizes prizes;
    private final Ladder ladder;

    public GameController(final ConnectionStrategy connectionStrategy) {
        this.names = readNamesWithRetry();
        this.prizes = readPrizesWithRetry(names.getSize());
        this.ladder = createdLadder(connectionStrategy);
    }

    private Names readNamesWithRetry() {
        try {
            return new Names(InputView.readNames());
        } catch (final IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readNamesWithRetry();
        }
    }

    private Prizes readPrizesWithRetry(final int size) {
        try {
            final List<String> prizeNames = InputView.readResults();
            validatePrizeSize(prizeNames, size);
            return new Prizes(prizeNames);
        } catch (final IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readPrizesWithRetry(size);
        }
    }

    private void validatePrizeSize(final List<String> prizeNames, final int size) {
        if (isDifferentSize(prizeNames, size)) {
            throw new IllegalArgumentException("결과의 수는 참여할 사람 수와 맞아야 합니다.");
        }
    }

    private boolean isDifferentSize(final List<String> prizeNames, final int size) {
        return prizeNames.size() != size;
    }


    private Ladder createdLadder(final ConnectionStrategy connectionStrategy) {
        try {
            final int height = InputView.readHeight();
            return new Ladder(height, names.getSize(), connectionStrategy);
        } catch (final IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readLadderHeightWithRetry(names, connectionStrategy);
        }
    }

    private Ladder readLadderHeightWithRetry(final Names names, final ConnectionStrategy connectionStrategy) {
        try {
            return new Ladder(InputView.readHeight(), names.getSize(), connectionStrategy);
        } catch (final IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readLadderHeightWithRetry(names, connectionStrategy);
        }
    }

    public void process() {
        printCreatedLadderAndPrizes(names, prizes, ladder);

        final Results results = startLadderGame(names, prizes, ladder);

        printResultsUntilEnd(results);
    }

    private void printCreatedLadderAndPrizes(final Names names, final Prizes prizes, final Ladder ladder) {
        OutputView.printPlayerAll(names);
        OutputView.printLadder(names, ladder);
        OutputView.printPrizesAll(prizes, names.findMaxNameLength());
    }

    private Results startLadderGame(final Names names, final Prizes prizes, final Ladder ladder) {
        final LadderGame ladderGame = LadderGame.of(ladder, new Players(names), prizes);
        ladderGame.startGame();
        return ladderGame.createResults();
    }

    private void printResultsUntilEnd(final Results results) {
        try {
            printResultAndCheckGameEnd(results);
        } catch (final IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private void printResultAndCheckGameEnd(final Results results) {
        Name resultName = null;

        while (canContinueGame(resultName)) {
            resultName = new Name(InputView.readResultPlayerName());
            printResult(results, resultName);
        }
    }

    private void printResult(final Results results, final Name resultName) {
        if (canContinueGame(resultName)) {
            final List<Result> outputResults = results.findResults(resultName);
            OutputView.printResult(outputResults);
        }
    }

    private boolean canContinueGame(final Name resultName) {
        return !END_SIGNAL.equals(resultName);
    }
}
