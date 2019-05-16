package ladder.controller;

import ladder.domain.*;
import ladder.view.InputConsoleView;
import ladder.view.OutputConsoleView;

import java.util.List;

public class LadderGameController {
    public void run() {
        GamePlayers gamePlayers = new GamePlayers(generatePlayers(inputNames()));
        PlayerRewards playerRewards = generateRewards(intputRewards());
        LadderGame ladderGame = new LadderGame(inputHeight(), gamePlayers, playerRewards);
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

    private String intputRewards() {
        return InputConsoleView.inputRewards();
    }

    private PlayerRewards generateRewards(String results) {
        return new PlayerRewardsGenerator(results).generate();
    }
}
