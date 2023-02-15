package laddergame.controller;

import laddergame.domain.LadderGame;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGameController {

    private final LadderGame ladderGame = new LadderGame();

    public void run() {
        initPlayers();
        initLadder();
        printLadderResult();
    }

    private void initPlayers() {
        OutputView.printPlayerNamesRequestMsg();
        List<String> playerNames = InputView.inputPlayerNames();
        ladderGame.setPlayers(playerNames);
    }

    private void initLadder() {
        OutputView.printLadderHeightRequestMsg();
        int ladderHeight = InputView.inputLadderHeight();
        ladderGame.makeLadder(ladderHeight);
    }

    private void printLadderResult() {
        OutputView.printResultInfoMsg();
        OutputView.printPlayerNames(ladderGame.getPlayerNames());
        OutputView.printLadderMap(ladderGame.getLadderMap());
    }
}
