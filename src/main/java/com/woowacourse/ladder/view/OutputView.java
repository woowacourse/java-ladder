package com.woowacourse.ladder.view;

import com.woowacourse.ladder.domain.DestinationGroup;
import com.woowacourse.ladder.domain.Direction;
import com.woowacourse.ladder.domain.LadderState;
import com.woowacourse.ladder.domain.ParticipantGroup;

import java.util.List;

public class OutputView {
    public static void printLadder(LadderState state, ParticipantGroup participants, DestinationGroup destinations) {
        System.out.println("사다리 결과\n");
        participants.forEachParticipants(p -> System.out.printf(" %-6s", p));
        System.out.println();
        state.forEachRows(OutputView::printEachRow);
        destinations.forEachDestinations(d -> System.out.printf(" %-6s", d));
        System.out.println();
    }

    private static void printEachRow(LadderState.LadderRow row) {
        System.out.print("    ");
        List<Direction> directions = row.getDirections();
        for (int i = 0; i < directions.size() - 1; i++) {
            System.out.printf("|%s", directions.get(i).equals(Direction.RIGHT) ? "-----" : "     ");
        }
        System.out.println("|");
    }

    public static void printSingleResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public static void printMultipleResult(List<String> participants, List<String> destinations) {
        assertLists(participants, destinations);

        System.out.println("실행 결과");
        for (int i = 0; i < participants.size(); i++) {
            System.out.printf("%s : %s\n", participants.get(i), destinations.get(i));
        }
    }

    private static void assertLists(List<String> participants, List<String> destinations) {
        if (participants == null || destinations == null ||
            participants.isEmpty() || destinations.isEmpty() ||
            participants.size() != destinations.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
