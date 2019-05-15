package com.woowacourse.ladder.view;

import com.woowacourse.ladder.domain.Ladder;
import com.woowacourse.ladder.domain.LadderResult;
import com.woowacourse.ladder.interfaces.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printLadder(Ladder<String> ladder) {
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
    }

    @Override
    public void printSingleResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    @Override
    public void printMultipleResult(LadderResult<String> result, List<String> expectedResults, List<String> namesToPrint) {
        System.out.println("실행 결과");
        for (String name : namesToPrint) {
            System.out.println(String.format("%s : %s", name, result.matchResult(expectedResults, name)));
        }
    }
}
