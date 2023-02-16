package view;

import domain.Bridge;
import domain.Ladder;
import domain.Line;

public class OutputView {

    public static void printLadder(final Ladder ladder) {
        System.out.println("실행결과");
        for (String name : ladder.getParticipantNames()) {
            System.out.print(name + "\t");
        }
        System.out.println();

        printLinesOf(ladder);
    }

    private static void printLinesOf(final Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.print("\t|");
            printBridgesOf(line);
            System.out.println();
        }
    }

    private static void printBridgesOf(final Line line) {
        for (Bridge bridge : line.getBridges()) {
            System.out.print(bridge.getDisplay());
            System.out.print("|");
        }
    }
}
