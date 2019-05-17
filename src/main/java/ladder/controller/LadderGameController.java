package ladder.controller;

import ladder.domain.*;
import ladder.domain.generator.PlayerGenerator;
import ladder.domain.generator.PlayerRewardsGenerator;
import ladder.view.InputConsoleView;
import ladder.view.OutputConsoleView;

import java.util.List;

public class LadderGameController {
    public void run() {
        GamePlayers gamePlayers = new GamePlayers(generatePlayers(inputNames()));
        PlayerRewards playerRewards = generateRewards(inputRewards());
        Ladder ladder = new Ladder(inputHeight(), gamePlayers.size());
        GameResult gameResult = new GameResult(ladder, gamePlayers, playerRewards);


        OutputConsoleView.printLadderGame(ladder, gamePlayers, playerRewards);
        String name = "";
        while (!(name = InputConsoleView.inputResultName()).equals("all")) {
            OutputConsoleView.printResult(gameResult, name);
        }
        OutputConsoleView.printResult(gameResult);
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

    private String inputRewards() {
        return InputConsoleView.inputRewards();
    }

    private PlayerRewards generateRewards(String results) {
        return new PlayerRewardsGenerator(results).generate();
    }
}
