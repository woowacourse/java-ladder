package com.woowacourse.ladder.view;

import com.woowacourse.ladder.domain.Ladder;
import com.woowacourse.ladder.domain.LadderResult;
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
        ladder.forEachRows(r -> {
            System.out.print("   |");
            String rowString = r.getColumnStream()
                .map(c -> {
                    if (c) {
                        return "-----";
                    }
                    return "     ";
                })
                .collect(Collectors.joining("|"));
            System.out.print(rowString);
            System.out.println("|");
        });
        ladder.forEachDestinations(p -> {
            System.out.printf("%-6s ", p);
        });
        System.out.println();
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
}
