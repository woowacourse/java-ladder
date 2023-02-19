package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.LadderGame;
import laddergame.domain.Players;
import laddergame.util.RandomPointGenerator;
import laddergame.util.RepeatValidator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGameController {

    public void run() {
        Players players = initPlayers();
        int ladderHeight = initLadder();
        Ladder ladder = new Ladder(players.size(), ladderHeight, new RandomPointGenerator());
        LadderGame ladderGame = new LadderGame(players, ladder);
        printLadderResult(ladderGame);
    }

    private Players initPlayers() {
        return RepeatValidator.retryUntilValidate(() -> {
            OutputView.printPlayerNamesRequestMsg();
            List<String> playerNames = InputView.inputPlayerNames();
            return new Players(playerNames);
        });
    }

    private int initLadder() {
        return RepeatValidator.retryUntilValidate(() -> {
            OutputView.printLadderHeightRequestMsg();
            int ladderHeight = InputView.inputLadderHeight();
            return ladderHeight;
        });
    }

    private void printLadderResult(LadderGame ladderGame) {
        OutputView.printResultInfoMsg();
        OutputView.printPlayerNames(ladderGame.getPlayerNames());
        OutputView.printLadderMap(ladderGame.getLadderMap());
    }
}
