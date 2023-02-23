package view;

import domain.Bridge;
import domain.BridgeStatus;
import domain.Ladder;

import java.util.List;

public class OutputLadderView {

    private static final String EMPTY_BRIDGE = "     ";
    private static final String EXIST_BRIDGE = "-----";
    private static final String LADDER_BOUNDARY = "|";
    private static final String TAB = "     ";


    public static void printLadder(final Ladder ladder) {
        System.out.println("사다리 결과");

        printParticipantsOf(ladder);

        System.out.println();

        printLinesOf(ladder);

        printResultCandidateOf(ladder);
    }

    private static void printParticipantsOf(final Ladder ladder) {
        for (String name : ladder.getParticipantNames()) {
            System.out.print(name + TAB);
        }
    }

    private static void printLinesOf(final Ladder ladder) {
        for (Bridge bridge : ladder.getBridges()) {
            System.out.print(LADDER_BOUNDARY);
            printBridgesOf(bridge);
            System.out.println();
        }
    }

    private static void printBridgesOf(final Bridge bridge) {
        for (BridgeStatus bridgeStatus : bridge.getBridgeStatuses()) {
            System.out.print(printBridgeStatus(bridgeStatus));
            System.out.print(LADDER_BOUNDARY);
        }
    }

    private static String printBridgeStatus(final BridgeStatus bridgeStatus) {
        if (bridgeStatus == BridgeStatus.EMPTY) {
            return EMPTY_BRIDGE;
        }

        return EXIST_BRIDGE;
    }

    private static void printResultCandidateOf(final Ladder ladder) {
        List<String> resultCandidates = ladder.getResultCandidates();

        for (String resultCandidate : resultCandidates) {
            System.out.print(resultCandidate + TAB);
        }

        System.out.println();
    }
}
