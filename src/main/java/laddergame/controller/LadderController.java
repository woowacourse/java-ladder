package laddergame.controller;

import laddergame.domain.result.Result;
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
        printDrawnLadder(players, targets, ladder);

        final Result result = ladderGame.start(players, ladder, targets);
        List<Player> playerToShowResult = players.find(getPlayersToShowResult());
        outputView.printResult(playerToShowResult, result);
    }

    private Players getPlayers() {
        Players players = ExceptionHandler.retryUntilInputIsValid(
                () -> new Players(inputView.readNames()), outputView
        );
        outputView.printLine();
        return players;
    }

    private Targets getTargets() {
        Targets targets = ExceptionHandler.retryUntilInputIsValid(
                () -> new Targets(inputView.readTargets()), outputView
        );
        outputView.printLine();
        return targets;
    }

    private LadderHeight getLadderHeight() {
        LadderHeight ladderHeight = ExceptionHandler.retryUntilInputIsValid(
                () -> new LadderHeight(inputView.readLadderHeight()), outputView
        );
        outputView.printLine();
        return ladderHeight;
    }

    private void printDrawnLadder(final Players players, final Targets targets, final Ladder ladder) {
        outputView.printDrawnLadder(DrawnLadderDto.of(players, targets, ladder));
    }

    private String getPlayersToShowResult() {
        return inputView.readPlayersToShowResult();
    }
}
