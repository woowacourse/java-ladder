package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.List;

public class OutputView {
    private static final String LADDER_UNCONNECTED = "     ";
    private static final String LADDER_CONNECTED = "-----";
    private static final String LADDER_LEG = "|";
    private static final String ALL_PARTICIPANTS = "all";

    public static void printNames(List<String> names) {
        System.out.println("실행 결과\n");

        for (String name : names) {
            System.out.printf("%6s", name);
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

    public static void printItems(List<String> items) {
        for (String item : items) {
            System.out.printf("%6s", item);
        }

        System.out.println();
    }

    public static void printResult(List<String> names, List<String> result, String participant) {
        System.out.println("실행 결과");
        if (participant.equals(ALL_PARTICIPANTS)) {
            printTotalResult(names, result);

            return;
        }

        System.out.println(participant + " : " + result.get(names.indexOf(participant)));
    }

    private static void printTotalResult(List<String> names, List<String> result) {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " : " + result.get(i));
        }
    }
}
