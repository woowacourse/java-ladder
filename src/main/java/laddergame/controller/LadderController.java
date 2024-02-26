package laddergame.controller;

import laddergame.domain.Result;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import laddergame.domain.target.Targets;
import laddergame.dto.DrawnLadderDto;
import laddergame.exception.ExceptionHandler;
import laddergame.service.LadderGame;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

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
        final Targets targets = getTargets();
        final LadderHeight height = getLadderHeight();

        final Ladder ladder = ladderGame.createLadder(players, height);
        final Result result = ladderGame.start(players, targets, ladder);

        printDrawnLadder(players, ladder);

        List<Player> playerToShowResult = players.find(getPlayersToShowResult());
    }

    private Players getPlayers() {
        return ExceptionHandler.retryUntilInputIsValid(() -> new Players(inputView.readNames()), outputView);
    }

    private Targets getTargets() {
        return ExceptionHandler.retryUntilInputIsValid(() -> new Targets(inputView.readTargets()), outputView);
    }

    private LadderHeight getLadderHeight() {
        return ExceptionHandler.retryUntilInputIsValid(() -> new LadderHeight(inputView.readLadderHeight()),
                outputView);
    }

    private void printDrawnLadder(final Players players, final Ladder ladder) {
        outputView.printResult(DrawnLadderDto.of(players, ladder));
    }

    private String getPlayersToShowResult() {
        return inputView.readPlayersToShowResult();
    }
}
