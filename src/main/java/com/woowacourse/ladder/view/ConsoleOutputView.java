package com.woowacourse.ladder.view;

import com.woowacourse.ladder.domain.Ladder;
import com.woowacourse.ladder.domain.LadderRow;
import com.woowacourse.ladder.domain.MatchPair;
import com.woowacourse.ladder.interfaces.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printLadder(Ladder<String, String> ladder) {
        System.out.print("");
        ladder.forEachParticipants(p -> {
            System.out.printf("%-6s ", p);
        });
        System.out.println();
        ladder.forEachRows(this::forEachRow);
        ladder.forEachDestinations(p -> {
            System.out.printf("%-6s ", p);
        });
        System.out.println();
    }

    private void forEachRow(LadderRow<String> r) {
        System.out.print("   |");
        String rowString = r.getColumnStream()
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
    public void printResult(List<MatchPair<String, String>> pairs) {
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
