package ladder.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LINE_BUNDLE = "-----";
    private static final String COLUMN_PART = "|";
    private static final String BLANK_BUNDLE = "     ";

    public static void printLadder(List<String> names, List<List<Boolean>> lines) {
        System.out.println("실행결과");
        System.out.println();
        printNames(names);
        printLines(lines);
    }

    private static void printNames(List<String> names) {
        String nameLine = names.stream()
                .map(name -> String.format("%6s", name))
                .collect(Collectors.joining());
        System.out.println(nameLine);
    }

    private static void printLines(List<List<Boolean>> lines) {
        for (List<Boolean> booleans : lines) {
            String line = booleans.stream()
                    .map(part -> COLUMN_PART + getBundlePart(part))
                    .collect(Collectors.joining());
            System.out.println(BLANK_BUNDLE + line + COLUMN_PART);
        }
    }

    private static String getBundlePart(boolean isAssigned) {
        if (isAssigned) {
            return LINE_BUNDLE;
        }
        return BLANK_BUNDLE;
    }
}
