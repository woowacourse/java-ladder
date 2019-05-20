package ladder.view;

import ladder.domain.*;

import java.util.List;

public class OutputView {
    private final static String CONNECTED = "-----";
    private final static String DISCONNECTED = "     ";

    public static void printNames(Players players) {
        System.out.println("\n사다리 결과\n");

        for (int i = 0; i < players.getSize(); i++) {
            System.out.printf("%6s", players.getPlayer(i));
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

    public static void printItems(Items items) {
        for (int i = 0; i < items.getSize(); i++) {
            System.out.printf("%6s", items.getItem(i));
        }
        System.out.println();
    }

    public static void printResult(Player participant, List<Item> finalResult, Players players) {
        System.out.println("\n실행 결과");
        if (participant.toString().equals("all")) {
            printForAll(finalResult, players);
            return;
        }
        System.out.println(finalResult.get(players.indexOf(participant)));
    }

    private static void printForAll(List<Item> finalResult, Players players) {
        for (int i = 0; i < players.getSize(); i++) {
            System.out.println(players.getPlayer(i) + " : " + finalResult.get(i));
        }
    }
}
