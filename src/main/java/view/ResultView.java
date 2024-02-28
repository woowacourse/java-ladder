package view;

import controller.LadderDto;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final int FIRST_NAME_INDEX = 0;

    private ResultView() {
    }

    public static void printLadderDrawResult(final LadderDto ladderDto) {
        printResultNotice();
        printNames(ladderDto.getNames());
        printLines(ladderDto.getNames(), ladderDto.getLines());
        printResults(ladderDto.getResults());
    }

    private static void printResultNotice() {
        System.out.println();
        System.out.println("사다리 결과\n");
    }

    private static void printNames(final List<String> names) {
        String firstName = names.get(FIRST_NAME_INDEX) + " ";
        StringBuilder nameLine = new StringBuilder();

        for (int i = 1; i < names.size(); i++) {
            nameLine.append(String.format("%6s", names.get(i)));
        }
        System.out.println(firstName + nameLine);
    }

    private static void printLines(final List<String> names, final List<List<Boolean>> lines) {
        for (List<Boolean> line : lines) {
            System.out.print(ResultMessage.ladderPadding(names));
            System.out.print(ResultMessage.of(line));
        }
    }

    private static void printResults(final List<String> results) {
        String firstResult = results.get(FIRST_NAME_INDEX) + " ";
        StringBuilder nameLine = new StringBuilder();

        for (int i = 1; i < results.size(); i++) {
            nameLine.append(String.format("%6s", results.get(i)));
        }
        System.out.println(firstResult + nameLine);
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
