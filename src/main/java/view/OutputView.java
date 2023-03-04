package view;

import java.util.List;
import java.util.Map;

import domain.Bridge;
import domain.Ladder;
import domain.LadderGame;
import domain.Line;
import dto.Result;

public class OutputView {

    private static final String EXCEPTION_PREFIX = "[ERROR] ";
    private static final String BRIDGE_EXIST_EXPRESSION = "-----";
    private static final String BRIDGE_EMPTY_EXPRESSION = "     ";

    public static void printLadder(final LadderGame ladderGame) {
        System.out.println("실행결과");
        printParticipantNames(ladderGame.getParticipantNames());
        printLinesOf(ladderGame.getLadder());
        printPrizes(ladderGame.getPrizes());
    }

    public static void printException(Exception exception) {
        System.out.println(EXCEPTION_PREFIX + exception.getMessage());
    }

    public static void printResults(List<Result> results) {
        for (var result : results) {
            if (results.size() > 1) {
                System.out.print(result.getParticipantName() + " : ");
            }
            System.out.println(result.getPrize());
        }
    }

    private static void printParticipantNames(List<String> participantNames) {
        for (String name : participantNames) {
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

    private static void printPrizes(final List<String> prizes) {
        for (String prize : prizes) {
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
