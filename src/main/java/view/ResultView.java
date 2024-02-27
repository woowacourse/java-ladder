package view;

import controller.LadderComponents;
import domain.Line;
import domain.Lines;
import domain.Names;
import domain.Results;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final int FIRST_NAME_INDEX = 0;

    private ResultView() {
    }

    public static void printLadderDrawResult(final LadderComponents ladderComponents) {
        printResultNotice();
        printNames(ladderComponents.getNames());
        printLines(ladderComponents.getNames(), ladderComponents.getLines());
        printResults(ladderComponents.getResults());
    }

    private static void printResults(final Results results) {
        String firstResult = results.resultOf(FIRST_NAME_INDEX) + " ";
        StringBuilder nameLine = new StringBuilder();

        for (int i = 1; i < results.size(); i++) {
            nameLine.append(String.format("%6s", results.resultOf(i)));
        }
        System.out.println(firstResult + nameLine);
    }

    private static void printLines(final Names names, final Lines lines) {
        for (Line line : lines.getLines()) {
            System.out.print(ResultMessage.ladderPadding(names));
            System.out.print(ResultMessage.of(line));
        }
    }

    private static void printNames(final Names names) {
        String firstName = names.nameOf(FIRST_NAME_INDEX) + " ";
        StringBuilder nameLine = new StringBuilder();

        for (int i = 1; i < names.size(); i++) {
            nameLine.append(String.format("%6s", names.nameOf(i)));
        }
        System.out.println(firstName + nameLine);
    }

    private static void printResultNotice() {
        System.out.println();
        System.out.println("사다리 결과\n");
    }

    public static void printMoveResult(final String result) {
        printMoveResultNotice();
        System.out.println(result);
    }

    public static void printMoveResult(final List<String> namesBeforeMove, final Map<String, String> results) {
        printMoveResultNotice();
        String resultValue = buildAllResult(namesBeforeMove, results);
        System.out.print(resultValue);
    }

    private static void printMoveResultNotice() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private static String buildAllResult(final List<String> namesBeforeMove, final Map<String, String> results) {
        StringBuilder result = new StringBuilder();
        for (String name : namesBeforeMove) {
            result.append(name);
            result.append(" : ");
            result.append(results.get(name));
            result.append("\n");
        }
        return result.toString();
    }
}
