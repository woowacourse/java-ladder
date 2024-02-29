package view;

import controller.LadderDto;
import domain.Line;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final int FIRST_NAME_INDEX = 0;

    private ResultView() {
    }

    public static void printLadderDrawResult(final LadderDto ladderDto) {
        printResultNotice();
        printInputValues(ladderDto.getNames());
        printLines(ladderDto.getNames(), ladderDto.getLines());
        printInputValues(ladderDto.getResults());
    }

    private static void printResultNotice() {
        System.out.println();
        System.out.println("사다리 결과\n");
    }

    private static void printInputValues(final List<String> names) {
        String firstName = names.get(FIRST_NAME_INDEX) + " ";
        StringBuilder nameLine = new StringBuilder();

        for (int i = 1; i < names.size(); i++) {
            nameLine.append(String.format("%6s", names.get(i)));
        }
        System.out.println(firstName + nameLine);
    }

    private static void printLines(final List<String> names, final List<Line> lines) {
        for (Line line : lines) {
            System.out.print(ResultMessage.ladderPadding(names));
            System.out.print(ResultMessage.of(line.getMovableLinePoints()));
        }
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
