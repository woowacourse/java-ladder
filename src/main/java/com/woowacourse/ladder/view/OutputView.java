package com.woowacourse.ladder.view;

import com.woowacourse.ladder.domain.*;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printLadder(PlayerList playerList, ResultItems resultItems, Ladder ladder) {
        List<Line> lines = ladder.getLines();
        playerList.getNames().stream().forEach(p -> {
            System.out.printf("%-6s ", p);
        });
        System.out.println();
        printLines(lines);
        resultItems.getResults().stream().forEach(r -> {
            System.out.printf("%-6s ", r);
        });
        System.out.println();
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

    public static Result executeOneResult(PlayerList playerList, Ladder ladder,
                                          String resultQueryName,
                                          ResultItems resultItems) {

        int index = playerList.findPlayer(resultQueryName);
        int position = ladder.stripeLadder(index);
        String resultName = playerList.getNames().get(index);
        String result = resultItems.getResults().get(position);

        return PartGenerator.generateResult(resultName, result);
    }

    public static void executePrintResult(PlayerList playerList, Ladder ladder, ResultItems resultItems) {
        List<Integer> positions = ladder.stripeAllLader();
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < playerList.getNames().size(); i++) {
            String name = playerList.getNames().get(i);
            String result = resultItems.getResults().get(positions.get(i));
            results.add(PartGenerator.generateResult(name, result));
        }
        OutputView.printResults(results);
    }

    public static void printResult(Result result) {
        System.out.println("실행결과");
        System.out.println(result.getResult());
    }

    public static void printResults(List<Result> results) {
        System.out.println("실행결과");
        results.forEach(System.out::print);
    }
}
