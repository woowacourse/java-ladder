package view;

import domain.BridgeStatus;
import domain.Ladder;
import domain.Line;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLadder(final Ladder ladder) {
        System.out.println("사다리 결과");

        printParticipantsOf(ladder);

        System.out.println();

        printLinesOf(ladder);

        printResultCandidateOf(ladder);
    }

    private static void printParticipantsOf(Ladder ladder) {
        for (String name : ladder.getParticipantNames()) {
            System.out.print(name + "\t");
        }
    }

    private static void printResultCandidateOf(Ladder ladder) {
        List<String> resultCandidates = ladder.getResultCandidates();

        for (String resultCandidate : resultCandidates) {
            System.out.print(resultCandidate + "\t");
        }

        System.out.println();
    }

    public static void printLadderResult(Map<String, String> result, String name) {
        System.out.println("실행결과");

        if (name.equals("all")) {
            printAll(result);
            return;
        }

        System.out.println(name + " : " + result.get(name));
    }

    private static void printAll(Map<String, String> result) {
        for (String participant : result.keySet()) {
            System.out.println(participant + " : " + result.get(participant));
        }
    }

    private static void printLinesOf(final Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.print("\t|");
            printBridgesOf(line);
            System.out.println();
        }
    }

    private static void printBridgesOf(final Line line) {
        for (BridgeStatus bridgeStatus : line.getBridges()) {
            System.out.print(bridgeStatus.getDisplay());
            System.out.print("|");
        }
    }
}
