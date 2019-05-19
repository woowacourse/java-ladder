package ladder;

import ladder.domain.*;
import ladder.domain.generator.DirectionsGeneratorFactory;
import ladder.domain.generator.PlayerGenerator;
import ladder.domain.generator.RewardsGenerator;
import ladder.view.InputConsoleView;
import ladder.view.OutputConsoleView;

import java.util.List;

public class LadderConsoleApp {
    public static void main(String[] args) {
        Players players = new Players(generatePlayers(InputConsoleView.inputNames()));
        Rewards rewards = generateRewards(InputConsoleView.inputRewards());
        Ladder ladder = new Ladder(InputConsoleView.inputHeight(), DirectionsGeneratorFactory.getInstance(players.size()));
        GameResult gameResult = new GameResult(ladder.play(players, rewards));

        OutputConsoleView.printLadderGame(ladder, players, rewards);

        String name;
        while (!(name = InputConsoleView.inputResultName()).equals("all")) {
            OutputConsoleView.printResult(gameResult, name);
        }
        OutputConsoleView.printResult(gameResult);
    }

    private static List<Player> generatePlayers(String names) {
        return new PlayerGenerator(names).generate();
    }

    private static Rewards generateRewards(String results) {
        return new RewardsGenerator(results).generate();
    }
}
