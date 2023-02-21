package ladder.view;

import ladder.dto.ResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LINE_BUNDLE = "-----";
    private static final String COLUMN_PART = "|";
    private static final String BLANK_BUNDLE = "     ";
    private static final String RESULT_DELIMITER = " : ";
    private static final int INQUIRE_ONE_NAME = 1;

    public static void printLadder(List<String> names, List<List<Boolean>> lines, List<String> resultNames) {
        System.out.println("사다리 결과");
        System.out.println();
        printNames(names);
        printLines(lines);
        printNames(resultNames);
    }

    public static void printInquireResult(List<ResultDto> results) {
        System.out.println();
        System.out.println("실행 결과");
        if (results.size() == INQUIRE_ONE_NAME) {
            System.out.println(results.get(0).getResult());
            return;
        }
        for (ResultDto result : results) {
            System.out.println(result.getName() + RESULT_DELIMITER + result.getResult());
        }
    }

    private static void printNames(List<String> names) {
        String nameLine = names.stream()
                .map(name -> String.format("%6s", name))
                .collect(Collectors.joining());
        System.out.println(nameLine);
    }

    private static void printLines(List<List<Boolean>> lines) {
        for (List<Boolean> booleans : lines) {
            String line = generateLine(booleans);
            System.out.println(BLANK_BUNDLE + line + COLUMN_PART);
        }
    }

    private static String generateLine(List<Boolean> booleans) {
        return booleans.stream()
                .map(part -> COLUMN_PART + getBundlePart(part))
                .collect(Collectors.joining());
    }

    private static String getBundlePart(boolean isAssigned) {
        if (isAssigned) {
            return LINE_BUNDLE;
        }
        return BLANK_BUNDLE;
    }
}
