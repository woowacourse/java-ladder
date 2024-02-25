package laddergame.controller;

import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.player.Players;
import laddergame.dto.GameResultDto;
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
        final LadderHeight height = getLadderHeight();

        final GameResultDto result = ladderGame.createLadder(players, height);

        outputView.printResult(result);
    }

    private Players getPlayers() {
        return ExceptionHandler.retryUntilInputIsValid(() -> new Players(inputView.readNames()), outputView);
    }

    private LadderHeight getLadderHeight() {
        return ExceptionHandler.retryUntilInputIsValid(() -> new LadderHeight(inputView.readLadderHeight()),
                outputView);
    }

}
