package com.woowacourse.ladder.view;

import com.woowacourse.ladder.domain.*;
import com.woowacourse.ladder.interfaces.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printLadder(LadderState ladderState, List<String> participants, List<String> destinations) {
        System.out.print("");
        participants.forEach(p -> {
            System.out.printf("%-6s ", p);
        });
        System.out.println();
        ladderState.getBooleanMatrix().forEach(this::forEachRow);
        destinations.forEach(p -> {
            System.out.printf("%-6s ", p);
        });
        System.out.println();
    }

    private void forEachRow(List<Boolean> rowBooleanState) {
        System.out.print("   |");
        String rowString = rowBooleanState
            .stream()
            .map(this::forEachColumns)
            .collect(Collectors.joining("|"));
        System.out.print(rowString);
        System.out.println("|");
    }

    private String forEachColumns(Boolean b) {
        if (b) {
            return "-----";
        }
        return "     ";
    }

    @Override
    public void printResult(List<MatchPair> pairs) {
        System.out.println("실행 결과");
        if (pairs.size() == 1) {
            System.out.println(pairs.get(0).getDestination());
            return;
        }
        pairs.forEach(p -> {
            System.out.println(String.format("%s : %s", p.getParticipant(), p.getDestination()));
        });
    }

    @Override
    public void printError(String message) {
        System.out.println(message);
    }
}
