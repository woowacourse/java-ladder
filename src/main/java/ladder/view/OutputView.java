package ladder.view;

import ladder.domain.*;

import java.util.List;

public class OutputView {
    private static final String LADDER_UNCONNECTED = "     ";
    private static final String LADDER_CONNECTED = "-----";
    private static final String LADDER_LEG = "|";
    private static final String ALL_PARTICIPANTS = "all";

    public static void printNames(Players players) {
        System.out.println("실행 결과\n");

        for (Player player : players.getPlayers()) {
            System.out.printf("%6s", player.getName());
        }

        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        int height = ladder.getHeight();
        int numberOfPeople = ladder.getNumberOfPeople();

        for (int row = 0; row < height; row++) {
            Line line = ladder.getLine(row);

            printLadderByLine(numberOfPeople, line);
        }
    }

    private static void printLadderByLine(int numberOfPeople, Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LADDER_UNCONNECTED);   // 왼쪽 공백

        for (int column = 0; column < numberOfPeople - 1; column++) {
            stringBuilder.append(LADDER_LEG);
            printConnected(line, stringBuilder, column);
        }

        stringBuilder.append(LADDER_LEG);
        System.out.println(stringBuilder.toString());
    }

    private static void printConnected(Line line, StringBuilder stringBuilder, int j) {
        if (line.isConnected(j)) {
            stringBuilder.append(LADDER_CONNECTED);
        }
        if (!line.isConnected(j)) {
            stringBuilder.append(LADDER_UNCONNECTED);
        }
    }

    public static void printItems(Items items) {
        for (String item : items.getItems()) {
            System.out.printf("%6s", item);
        }

        System.out.println();
    }

    public static void printResult(Players players, List<String> result, String participant) {
        System.out.println("실행 결과");
        if (participant.equals(ALL_PARTICIPANTS)) {
            printTotalResult(players, result);

            return;
        }

        System.out.println(participant + " : " + result.get(players.getIndex(participant)));
    }

    private static void printTotalResult(Players players, List<String> result) {
        for (int i = 0; i < players.getNumberOfPlayers(); i++) {
            System.out.println(players.getPlayers().get(i).getName() + " : " + result.get(i));
        }
    }
}
