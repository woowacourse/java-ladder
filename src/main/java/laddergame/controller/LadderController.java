package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.player.Players;
import laddergame.domain.result.Result;
import laddergame.domain.target.Targets;
import laddergame.dto.DrawnLadderDto;
import laddergame.exception.ExceptionHandler;
import laddergame.service.LadderGame;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGame ladderGame;

    public LadderController(final InputView inputView, final OutputView outputView, final LadderGame ladderGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGame = ladderGame;
    }

    public void run() {
        final Players players = getPlayers();
        final Targets targets = getTargets(players.getSize());
        final LadderHeight height = getLadderHeight();

        final Ladder ladder = ladderGame.createLadder(players, height);
        printLadder(players, targets, ladder);

        final Result result = ladderGame.start(players, ladder, targets);
        printResult(result);
    }

    private Players getPlayers() {
        final Players players = ExceptionHandler.retryUntilInputIsValid(
                () -> new Players(inputView.readNames()), outputView
        );
        outputView.printLine();

        return players;
    }

    private Targets getTargets(final int size) {
        final Targets targets = ExceptionHandler.retryUntilInputIsValid(
                () -> new Targets(inputView.readTargets(), size), outputView
        );
        outputView.printLine();

        return targets;
    }

    private LadderHeight getLadderHeight() {
        final LadderHeight ladderHeight = ExceptionHandler.retryUntilInputIsValid(
                () -> new LadderHeight(inputView.readLadderHeight()), outputView
        );
        outputView.printLine();

        return ladderHeight;
    }

    private void printLadder(final Players players, final Targets targets, final Ladder ladder) {
        outputView.printLadder(DrawnLadderDto.of(players, targets, ladder));
    }

    private void printResult(final Result result) {
        final String input = getDisplayingPlayers();

        if (input.equals("all")) {
            outputView.printResultAll(result);
            return;
        }

        outputView.printResult(result.findByName(input));
    }

    private String getDisplayingPlayers() {
        return inputView.readDisplayingPlayers();
    }
}
