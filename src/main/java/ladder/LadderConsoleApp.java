package ladder;

import ladder.domain.*;
import ladder.domain.generator.PlayerGenerator;
import ladder.domain.generator.PlayerRewardsGenerator;
import ladder.view.InputConsoleView;
import ladder.view.OutputConsoleView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LadderConsoleApp {
    private static final String ALL_NAMES = "all";
    private static final Set<String> END_GAME = new HashSet<>();

    static {
        END_GAME.add("EXIT");
    }

    public static void main(String[] args) {
        GamePlayers gamePlayers = new GamePlayers(generatePlayers(inputNames()));
        PlayerRewards playerRewards = generateRewards(inputRewards());
        Ladder ladder = new Ladder(inputHeight(), gamePlayers.size());
        GameResult gameResult = new GameResult(ladder, gamePlayers, playerRewards);

        OutputConsoleView.printLadderGame(ladder, gamePlayers, playerRewards);
        String name = null;
        while (continueGame(name = InputConsoleView.inputResultName())) {
            if (name.equals(ALL_NAMES)) {
                OutputConsoleView.printResult(gameResult);
                continue;
            }
            OutputConsoleView.printResult(gameResult, new Player(name));
        }
        OutputConsoleView.printResult(gameResult);
    }

    private static List<Player> generatePlayers(String names) {
        return new PlayerGenerator(names).generate();
    }

    private static String inputNames() {
        return InputConsoleView.inputNames();
    }

    private static int inputHeight() {
        return InputConsoleView.inputHeight();
    }

    private static String inputRewards() {
        return InputConsoleView.inputRewards();
    }

    private static PlayerRewards generateRewards(String results) {
        return new PlayerRewardsGenerator(results).generate();
    }

    private static boolean continueGame(String name) {
        return !END_GAME.contains(name);
    }
}
