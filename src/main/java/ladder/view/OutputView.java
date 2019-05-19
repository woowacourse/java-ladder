package ladder.view;

import ladder.domain.*;

import java.util.List;

public class OutputView {

    public static void print(Players players, Ladder ladder, LadderRewards ladderRewards) {
        System.out.println(ConsoleMessages.OUTPUT_LADDER.message());
        printPlayers(players);
        print(ladder);
        printRewards(ladderRewards);
    }

    public static void print(PlayerResult playerResult) {
        System.out.println(ConsoleMessages.OUTPUT_RESULT.message());
        System.out.println(result(playerResult));
        System.out.println();
    }

    public static void print(List<PlayerResult> playerResults) {
        System.out.println(ConsoleMessages.OUTPUT_RESULT.message());
        System.out.println(result(playerResults));
        System.out.println();
    }

    public static void print(Ladder ladder) {
        List<LadderRow> rows = ladder.status();
        for (int i = 0; i < rows.size(); i++) {
            System.out.println(line(rows.get(i)));
        }
    }

    private static void printPlayers(Players players) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players.list()) {
            stringBuilder.append(String.format("%6s", player.name()));
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder.toString());
    }

    private static void printRewards(LadderRewards ladderRewards) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String reward : ladderRewards.reward()) {
            stringBuilder.append(String.format("%6s", reward));
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.toString());
    }

    public static String line(LadderRow row) {
        List<Integer> info = row.status();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   ");
        for (int i = 0; i < info.size() - 1; i++) {
            stringBuilder.append("|");
            stringBuilder.append(mark(info.get(i)));

        }
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    private static String mark(Integer number) {
        if (number == LadderRules.RIGHT.number()) {
            return "-----";
        }
        return "     ";
    }

    public static String result(PlayerResult playerResult) {
        return playerResult.reward();

    }

    public static String result(List<PlayerResult> playerResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (PlayerResult playerResult : playerResults) {
            stringBuilder.append(playerResult.name());
            stringBuilder.append(" : ");
            stringBuilder.append(playerResult.reward());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
