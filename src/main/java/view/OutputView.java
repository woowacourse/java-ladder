package view;

import domain.Ladder;
import domain.Line;

public class OutputView {

    public static void printLadder(Ladder ladder) {
        for (String name : ladder.getParticipantNames()) {
            System.out.print(name + "\t");
        }
        System.out.println();

        printLinesOf(ladder);
    }

    private static void printLinesOf(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.print("\t|");
            printBridgesOf(line);
            System.out.println();
        }
    }

    private static void printBridgesOf(Line line) {
        for (Boolean bridge : line.getBridges()) {
            System.out.print(getStatusOf(bridge));
            System.out.print("|");
        }
    }

    private static String getStatusOf(Boolean bridge) {
        if (bridge.equals(true)) {
            return "-----";
        }
        return "     ";
    }
}
