package ui.output;

import domain.Lines;
import domain.Players;
import domain.Result;
import domain.Results;

public class OutputView {

    private static final String EXECUTE_LADDER_RESULT = "사다리 결과";
    private static final String EXECUTE_RESULT = "실행 결과";

    public static void printLadderResult(final Players players, final Lines lines, final Results results) {
        System.out.println("\n" + EXECUTE_LADDER_RESULT + "\n");
        printPlayersName(players);
        printLadder(lines, players);
        printResults(results);
    }

    private static void printPlayersName(Players players) {
        int maxPlayerNameLength = getMaxLength(players);
        calculateNamePosition(players, maxPlayerNameLength);
    }

    private static int getMaxLength(Players players) {
        return players.getPlayers().stream()
                .mapToInt(player -> player.getName().length())
                .max()
                .orElseThrow();
    }

    private static void calculateNamePosition(Players players, int maxPlayerNameLength) {
        players.getPlayers().stream()
                .forEach(player ->
                        System.out.print(" ".repeat(maxPlayerNameLength - player.getName().length()) + player.getName() + " ")
                );
        System.out.println();
    }

    private static void printLadder(Lines lines, Players players) {
        lines.getLines()
                .forEach(line ->{
                            System.out.println(LadderShape.getLadderForm(line.getPoints(), getMaxLength(players)));
                });
    }

    private static void printResults(Results results) {
        for (Result result : results.getResults()) {
            System.out.print(" ".repeat(5 - result.getResult().length()) + result.getResult() + " ");
        }
        System.out.println();
    }

    public static void printExecuteResult() {
        System.out.println(EXECUTE_RESULT);
    }
}
