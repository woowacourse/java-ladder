package ladder.view;

import ladder.dto.ResultDto;
import ladder.dto.ResultDtos;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String EXIST_BRIDGE = "-----";
    private static final String COLUMN_PART = "|";
    private static final String BLANK_BRIDGE = "     ";
    private static final String RESULT_DELIMITER = " : ";
    private static final int INQUIRE_ONE_NAME = 1;

    public static void printLadder(List<String> names, List<List<Boolean>> lines, List<String> resultNames) {
        System.out.println("사다리 결과");
        System.out.println();
        printNames(names);
        printLines(lines);
        printNames(resultNames);
    }

    public static void printInquireResult(ResultDtos results) {
        System.out.println();
        System.out.println("실행 결과");
        if (results.size() == INQUIRE_ONE_NAME) {
            printOneResult(results);
            return;
        }
        printAllResult(results);
    }

    private static void printOneResult(ResultDtos results) {
        String firstResult = results.getResult(0);
        System.out.println(firstResult);
    }

    private static void printAllResult(ResultDtos results) {
        StringBuilder sb = new StringBuilder();

        for (ResultDto result : results.getResultDtos()) {
            String resultBundle = sb.append(result.getName())
                    .append(RESULT_DELIMITER)
                    .append(result.getResult())
                    .toString();
            System.out.println(resultBundle);
            sb.setLength(0);
        }
    }

    private static void printNames(List<String> names) {
        String nameLine = names.stream()
                .map(name -> String.format("%6s", name))
                .collect(Collectors.joining());
        System.out.println(nameLine);
    }

    private static void printLines(List<List<Boolean>> lines) {
        StringBuilder sb = new StringBuilder();
        for (List<Boolean> bridges : lines) {
            String line = generateLine(bridges);
            System.out.println(sb.append(BLANK_BRIDGE).append(line).append(COLUMN_PART));
            sb.setLength(0);
        }
    }

    private static String generateLine(List<Boolean> bridges) {
        StringBuilder sb = new StringBuilder();

        bridges.forEach(isAssigned -> {
            sb.append(COLUMN_PART).append(getBridge(isAssigned));
        });
        return sb.toString();
    }

    private static String getBridge(boolean isAssigned) {
        if (isAssigned) {
            return EXIST_BRIDGE;
        }
        return BLANK_BRIDGE;
    }
}
