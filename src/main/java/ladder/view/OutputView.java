package ladder.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LINE_PART = "-";
    private static final String COLUMN_PART = "|";
    private static final String BLANK_PART = " ";

    public static void printLadder(List<String> names, List<List<Boolean>> lines, int nameMaxLength) {
        System.out.println("실행결과");
        System.out.println();
        printNames(names, nameMaxLength);
        printLines(lines, nameMaxLength);
    }

    private static void printNames(List<String> names, int nameMaxLength) {
        String nameLine = names.stream()
                .map(name -> String.format("%" + (nameMaxLength + 1) + "s", name))
                .collect(Collectors.joining());
        System.out.println(nameLine);
    }

    private static void printLines(List<List<Boolean>> lines, int nameMaxLength) {
        for (List<Boolean> booleans : lines) {
            String line = booleans.stream()
                    .map(part -> COLUMN_PART + getBundlePart(nameMaxLength, part))
                    .collect(Collectors.joining());
            System.out.println(getBundlePart(nameMaxLength, false) + line + COLUMN_PART);
        }
    }

    private static String getBundlePart(int partWidth, boolean isAssigned) {
        if (isAssigned) {
            return LINE_PART.repeat(partWidth);
        }
        return BLANK_PART.repeat(partWidth);
    }
}
