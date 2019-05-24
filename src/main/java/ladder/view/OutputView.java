package ladder.view;

import ladder.domain.gamecomponent.*;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PRINT_RESULT_INDEX = "실행결과";
    private static final String PRINT_END_GAME = "사다리 게임이 종료되었습니다.";

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
        try {
            PlayerName name = new PlayerName(input);
            Result result = gameResult.getResult(name);

            System.out.println(PRINT_RESULT_INDEX);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printAllGameResults(LadderGameResult gameResult) {
        System.out.println(PRINT_RESULT_INDEX);

        Map<PlayerName, Result> result = gameResult.getGameResult();
        for (PlayerName name : result.keySet()) {
            System.out.println(name + " : " + result.get(name));
        }
    }

    public static void printEnd() {
        System.out.println(PRINT_END_GAME);
    }
}
