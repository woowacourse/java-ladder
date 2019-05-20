package laddergame.view;

import laddergame.domain.*;

import java.util.*;

public class OutputView {

    public static void printPlayersAndLadder(Players players, Ladder ladder) {
        printPlayers(players);
        printLadder(ladder);
    }

    private static void printPlayers(Players players) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Player player : players.getPlayers()) {
            stringBuilder.append(String.format("%6s", player.getName().getName()));
        }
        stringBuilder.append("\n");

        System.out.println(stringBuilder.toString());
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < ladder.getHeight(); y++) {
            appendHandle(sb, y, ladder);
        }

        System.out.println(sb.toString());
    }

    private static void appendHandle(StringBuilder sb, int y, Ladder ladder) {
        sb.append("     |");
        for (int x = 0; x < ladder.getWidth() - 1; x++) {
            sb.append(ladder.getLadderInformationAsTrueFalse().get(y).getBooleanValue(x) ? "-----|" : "     |");
        }
        sb.append("\n");
    }

    public static void printPrizes(Prizes prizes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Prize prize : prizes.getPrizes()) {
            stringBuilder.append(String.format("%6s", prize.getPrize()));
        }

        System.out.println(stringBuilder.toString());
    }

    public static void printResult(GameResult result) {
        if (result.isRequestAll()) {
            printAllResults(result);
            return;
        }
        printRequestedResult(result);
    }

    private static void printRequestedResult(GameResult result) {
        int index = 0;

        while (index < result.getResultsSize() && !result.isMatch(index)) {
            index++;
        }

        System.out.println(result.getResults().get(index));
    }

    private static void printAllResults(GameResult result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String currentResult : result.getResults()) {
            stringBuilder.append(currentResult);
        }
        System.out.println(stringBuilder.toString());
    }
}
