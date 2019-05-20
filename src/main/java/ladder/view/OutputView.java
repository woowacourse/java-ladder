package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLadderGameBoard(Players players, Results results, Ladder ladder) {
        printPlayers(players.getPlayers());
        System.out.println(ladder);
        printResult(results.getResults());
    }

    private static void printPlayers(List<Player> players) {
        for (Player player : players) {
            System.out.printf("%-6s", player.getName());
        }
        System.out.println();
    }

    private static void printResult(List<Result> results) {
        for (Result result : results) {
            System.out.printf("%-6s", result);
        }
        System.out.println();
    }

    public static void printGameResult(String input, LadderGameResult gameResult) {
        System.out.println(UserOutput.PRINT_RESULT_INDEX.getOutputMessage());
        PlayerName name = new PlayerName(input);
        System.out.println(gameResult.getGameResult().get(name));
    }

    public static void printAllGameResults(LadderGameResult gameResult) {
        System.out.println(UserOutput.PRINT_RESULT_INDEX.getOutputMessage());

        Map<PlayerName, Result> result = gameResult.getGameResult();
        for (PlayerName name : result.keySet()) {
            System.out.println(name + " : " + result.get(name));
        }
    }

    public static void printEnd() {
        System.out.println(UserOutput.PRINT_END_GAME.getOutputMessage());
    }
}
