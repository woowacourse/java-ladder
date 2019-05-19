package ladder;

import ladder.domain.GameResult;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Rewards;
import ladder.domain.generator.DirectionsGeneratorFactory;
import ladder.domain.generator.PlayersGenerator;
import ladder.domain.generator.RewardsGenerator;
import ladder.view.InputConsoleView;
import ladder.view.OutputConsoleView;

public class LadderConsoleApp {
    public static void main(String[] args) {
        Players players = generatePlayers(InputConsoleView.inputNames());
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

    private static Players generatePlayers(String names) {
        return new PlayersGenerator(names).generate();
    }

    private static Rewards generateRewards(String results) {
        return new RewardsGenerator(results).generate();
    }
}
