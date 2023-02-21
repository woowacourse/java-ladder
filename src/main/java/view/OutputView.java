package view;

import java.util.List;
import java.util.Map;

import domain.Bridge;
import domain.Ladder;
import domain.Line;
import domain.Participants;

public class OutputView {

    private static final String EXCEPTION_PREFIX = "[ERROR] ";
    private static final String BRIDGE_EXIST_EXPRESSION = "-----";
    private static final String BRIDGE_EMPTY_EXPRESSION = "     ";

    public static void printLadder(final Ladder ladder) {
        System.out.println("실행결과");
        printParticipantNamesOf(ladder);
        printLinesOf(ladder);
        printPrizesOf(ladder);
    }

    public static void printException(Exception exception) {
        System.out.println(EXCEPTION_PREFIX + exception.getMessage());
    }

    public static void printResults(Map<String, String> results) {
        for (var result : results.entrySet()) {
            if (results.size() > 1) {
                System.out.print(result.getKey() + " : ");
            }
            System.out.println(result.getValue());
        }
    }

    private static void printParticipantNamesOf(Ladder ladder) {
        for (String name : ladder.getParticipantNames()) {
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

    private static void printPrizesOf(final Ladder ladder) {
        for (String prize : ladder.getPrizes()) {
            System.out.print(prize + "\t");
        }
        System.out.println();
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
