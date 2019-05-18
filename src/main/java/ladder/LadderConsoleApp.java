package ladder;

import ladder.domain.*;
import ladder.domain.generator.PlayerGenerator;
import ladder.domain.generator.PlayerRewardsGenerator;
import ladder.view.InputConsoleView;
import ladder.view.OutputConsoleView;

import java.util.List;

public class LadderConsoleApp {
    public static void main(String[] args) {
        GamePlayers gamePlayers = new GamePlayers(generatePlayers(InputConsoleView.inputNames()));
        PlayerRewards playerRewards = generateRewards(InputConsoleView.inputRewards());
        Ladder ladder = new Ladder(InputConsoleView.inputHeight(), gamePlayers.size());
        GameResult gameResult = new GameResult(ladder, gamePlayers, playerRewards);

        OutputConsoleView.printLadderGame(ladder, gamePlayers, playerRewards);
        String name;
        while (!(name = InputConsoleView.inputResultName()).equals("all")) {
            OutputConsoleView.printResult(gameResult, name);
        }
        OutputConsoleView.printResult(gameResult);
    }

    private static List<Player> generatePlayers(String names) {
        return new PlayerGenerator(names).generate();
    }

    private static PlayerRewards generateRewards(String results) {
        return new PlayerRewardsGenerator(results).generate();
    }
}
