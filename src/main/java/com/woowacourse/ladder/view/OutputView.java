package com.woowacourse.ladder.view;

import com.woowacourse.ladder.domain.*;

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

    public static void printResult(ResultPair result) {
        if (result.size() == 1) {
            result.forEachPair((p, d) -> printSingleResult(d.toString()));
            return;
        }

        OutputView.printMultipleResult(result);
    }

    private static void printSingleResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    private static void printMultipleResult(ResultPair result) {
        assertNotNull(result);

        System.out.println("실행 결과");
        result.forEachPair((p, d) -> {
            System.out.printf("%s : %s\n", p, d);
        });
    }

    private static void assertNotNull(ResultPair result) {
        if (result == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
