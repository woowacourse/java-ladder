package ladder.controller;

import ladder.domain.*;
import ladder.view.InputConsoleView;
import ladder.view.OutputConsoleView;

import java.util.List;

public class LadderGameController {
    public void run() {
        GamePlayers gamePlayers = new GamePlayers(generatePlayers(inputNames()));
        LadderGame ladderGame = new LadderGame(inputHeight(), gamePlayers);
        OutputConsoleView.printLadderGame(ladderGame);
    }

    private List<Player> generatePlayers(String names) {
        return new PlayerGenerator(names).generate();
    }

    private String inputNames() {
        return InputConsoleView.inputNames();
    }

    private int inputHeight() {
        return InputConsoleView.inputHeight();
    }
}
