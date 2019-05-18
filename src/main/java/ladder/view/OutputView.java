package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.List;

public class OutputView {
    private final static String CONNECTED = "-----";
    private final static String DISCONNECTED = "     ";

    public static void printNames(List<String> names) {
        System.out.println("\n사다리 결과\n");

        for (String name : names) {
            System.out.printf("%6s", name);
        }
        System.out.println();
    }

    public static void printLadderBody(Ladder ladder) {
        int height = ladder.getHeight();
        int numberOfPeople = ladder.getNumberOfPeople();

        for (int i = 0; i < height; i++) {
            Line line = ladder.getLine(i);
            printLadderLine(line, numberOfPeople);
        }
    }

    private static void printLadderLine(Line line, int numberOfPeople) {
        StringBuilder printLine = new StringBuilder();
        printLine.append("     ");
        for (int j = 0; j < numberOfPeople - 1; j++) {
            printLine.append("|");
            printLine.append(LineStructure(line, j));
        }
        printLine.append("|");
        System.out.println(printLine);
    }

    private static String LineStructure(Line line, int index) {
        if (line.isConnected(index)) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public static void printItems(List<String> items) {
        for (String item : items) {
            System.out.printf("%6s", item);
        }
        System.out.println();
    }

    public static void printResult(String participant, List<String> finalResult, List<String> names) {
        System.out.println("\n실행 결과");
        if (participant.equals("all")) {
            printForAll(finalResult, names);
            return;
        }
        System.out.println(finalResult.get(names.indexOf(participant)));
    }

    private static void printForAll(List<String> finalResult, List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " : " + finalResult.get(i));
        }
    }
}
