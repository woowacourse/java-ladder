package view;

import domain.Bridge;
import domain.Ladder;
import domain.Line;

public class OutputView {

    private static final String EXCEPTION_PREFIX = "[ERROR] ";
    private static final String BRIDGE_EXIST_EXPRESSION = "-----";
    private static final String BRIDGE_EMPTY_EXPRESSION = "     ";

    public static void printLadder(final Ladder ladder) {
        System.out.println("실행결과");
        printParticipantNamesOf(ladder);
        printLinesOf(ladder);
    }

    public static void printException(Exception exception) {
        System.out.println(EXCEPTION_PREFIX + exception.getMessage());
    }

    private static void printParticipantNamesOf(Ladder ladder) {
        for (String name : ladder.getParticipants().getNames()) {
            System.out.print(name + "\t");
        }
        System.out.println();
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
            System.out.print(getExpressionFor(bridge));
            System.out.print("|");
        }
    }

    private static String getExpressionFor(Bridge bridge) {
        if (bridge.doesExist()) {
            return BRIDGE_EXIST_EXPRESSION;
        }
        return BRIDGE_EMPTY_EXPRESSION;
    }
}
