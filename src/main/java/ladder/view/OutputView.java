package ladder.view;

import ladder.domain.*;

public class OutputView {
    private final static String CONNECTED = "-----";
    private final static String DISCONNECTED = "     ";
    private static final String PARTICIPANT_ALL = "all";

    public static void printPlayers(Players players) {
        System.out.println("\n사다리 결과\n");

        for (int i = 0; i < players.getNumberOfPlayers(); i++) {
            System.out.printf("%6s", players.getPlayer(i));
        }
        System.out.println();
    }

    public static void printLadderBody(Ladder ladder) {
        int height = ladder.getHeight();
        int numberOfPeople = ladder.getNumberOfPlayers();

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
            printLine.append(buildLineStructure(line, j));
        }
        printLine.append("|");
        System.out.println(printLine);
    }

    private static String buildLineStructure(Line line, int index) {
        if (line.isConnectedToRight(index)) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public static void printItems(Items items) {
        for (int i = 0; i < items.getNumberOfItems(); i++) {
            System.out.printf("%6s", items.getItem(i));
        }
        System.out.println();
    }

    public static void printResult(Player participant, LadderResult ladderResult, Players players) {
        System.out.println("\n실행 결과");
        if (participant.toString().equals(PARTICIPANT_ALL)) {
            printForAll(ladderResult, players);
            return;
        }
        System.out.println(ladderResult.getItemByPlayer(participant));
    }

    private static void printForAll(LadderResult ladderResult, Players players) {
        for (int i = 0; i < players.getNumberOfPlayers(); i++) {
            Player player = players.getPlayer(i);
            System.out.println(player + " : " + ladderResult.getItemByPlayer(player));
        }
    }
}
