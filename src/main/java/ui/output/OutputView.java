package ui.output;

import domain.*;

public class OutputView {

    private static final String EXECUTE_LADDER_RESULT = "사다리 결과";
    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String ALL = "all";
    private static final String SPACE = " ";
    private static final String COLON = " : ";

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
        players.getPlayers()
                .forEach(player ->
                        System.out.print(SPACE.repeat(maxPlayerNameLength - player.getName().length()) + player.getName() + SPACE)
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
            System.out.print(" ".repeat(5 - result.getResult().length()) + result.getResult() + SPACE);
        }
        System.out.println();
    }

    public static void printExecuteResult(Players players, Results results, String playerName) {
        System.out.println("\n" + EXECUTE_RESULT);
        if (playerName.equals(ALL)) {
            printAll(players, results);
            return;
        }
        printDetail(players, results, playerName);
    }

    private static void printAll(Players players, Results results) {
        for (Player player : players.getPlayers()) {
            System.out.println(player.getName() + COLON + results.getResults().get(getResultIndex(players, player.getName())).getResult());
        }
    }

    private static void printDetail(Players players, Results results, String playerName) {
        players.getPlayers().stream()
                .filter(player -> player.getName().equals(playerName))
                .forEach(player -> {
                    System.out.println(results.getResults().get(getResultIndex(players, playerName)).getResult());
                });
    }

    private static int getResultIndex(Players players, String playerName) {
        for (int i = 0; i < players.getPlayers().size(); i++) {
            if (players.getPlayers().get(i).getName().equals(playerName)) return i;
        }
        return -1;
    }
}
