package view;

import domain.*;

import java.util.Map;
import java.util.Scanner;

public class ResultView {
    private static final String ALL_RESULT_COMMAND = "all";
    private static final Scanner scanner = new Scanner(System.in);

    private ResultView() {
    }

    public static void printLadder(Names names, Lines lines, Results results) {
        printResultNotice();
        printNames(names);
        printLines(names, lines);
        printResults(results);
    }

    private static void printResultNotice() {
        System.out.println();
        System.out.println("실행결과\n");
    }

    private static void printNames(Names names) {
        String firstName = names.firstName() + " ";
        StringBuilder nameLine = new StringBuilder();

        for (int i = 1; i < names.size(); i++) {
            nameLine.append(String.format("%6s", names.nameOf(i)));
        }
        System.out.println(firstName + nameLine);
    }

    private static void printLines(Names names, Lines lines) {
        for (Line line : lines.getLines()) {
            System.out.print(ResultMessage.ladderPadding(names));
            System.out.print(ResultMessage.of(line));
        }
    }

    private static void printResults(Results results) {
        StringBuilder resultLine = new StringBuilder();

        for (int i = 0; i < results.size(); i++) {
            resultLine.append(String.format("%-6s", results.getResults().get(i).getData()));
        }
        System.out.println(resultLine);
    }

    public static void printGameResult(Results results, Map<Name, Integer> gameResult) {
        String input = "";

        while (!input.equals(ALL_RESULT_COMMAND)) {
            input = inputSearchKey();

            System.out.println();
            System.out.println("실행 결과");

            StringBuilder searchResult = searchResult(results, gameResult, input);
            System.out.println(searchResult);
        }
    }

    private static StringBuilder searchResult(Results results, Map<Name, Integer> gameResult, String input) {
        StringBuilder resultLine = new StringBuilder();

        if (input.equals("all")) {
            return allResultBuilder(results, gameResult, resultLine);
        }

        return singleResultBuilder(results, gameResult, input, resultLine);
    }

    private static StringBuilder singleResultBuilder(Results results, Map<Name, Integer> gameResult, String input, StringBuilder resultLine) {
        Integer index = gameResult.get(new Name(input));
        resultLine.append(results.findByIndex(index));
        return resultLine;
    }

    private static StringBuilder allResultBuilder(Results results, Map<Name, Integer> gameResult, StringBuilder resultLine) {
        gameResult.forEach((key, value) -> resultLine.append(key.getValue() + " : " + results.findByIndex(value) + "\n"));
        return resultLine;
    }

    private static String inputSearchKey() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
