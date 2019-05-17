package com.woowacourse.ladder.view;

import com.woowacourse.ladder.Ladder;
import com.woowacourse.ladder.Line;
import com.woowacourse.ladder.PlayerList;
import com.woowacourse.ladder.ResultList;
import javafx.beans.binding.BooleanBinding;

import java.util.List;

public class OutputView {
    public static void printLadder(PlayerList playerList, ResultList resultList, Ladder ladder) {
        List<Line> lines = ladder.getLines();
        playerList.getNames().stream().forEach(p -> {
            System.out.printf("%-6s ", p);
        });
        System.out.println();
        printLines(lines);
        resultList.getResults().stream().forEach(r -> {
            System.out.printf("%-6s ", r);
        });
    }

    private static void printLines(List<Line> lines) {
        for (int i = 0; i < lines.size(); i++) {
            List<Boolean> bools = lines.get(i).getBridges();
            printLine(bools);
        }
    }

    private static void printLine(List<Boolean> bools) {
        System.out.print("    ");
        for (int j = 0; j < bools.size(); j++) {
            System.out.print("|");
            printBridge(bools, j);
        }
        System.out.println("|");
    }

    private static void printBridge(List<Boolean> booleanList, int i) {
        if (booleanList.get(i)) {
            System.out.print("=====");
            return;
        }
        System.out.print("     ");
    }
}
