package ladder.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LINE_PART = "-";
    private static final String COLUMN_PART = "|";
    private static final String BLANK_PART = " ";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    public static void printLadder(List<String> names, List<List<Boolean>> lines, List<String> items, int nameMaxLength) {
        System.out.println("사다리 결과");
        System.out.println();
        printNames(names, nameMaxLength);
        printLines(lines, nameMaxLength);
        printItems(items, nameMaxLength);
        System.out.println();
    }

    private static void printNames(List<String> names, int nameMaxLength) {
        String playerNames = names.stream()
                .map(name -> String.format("%" + (nameMaxLength + 1) + "s", name))
                .collect(Collectors.joining());
        System.out.println(playerNames);
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

    private static void printItems(List<String> ladderGameItems, int nameMaxLength) {
        String items = ladderGameItems.stream()
                .map(item -> String.format("%" + (nameMaxLength + 1) + "s", item))
                .collect(Collectors.joining());
        System.out.println(items);
    }

    public static void printPlayerResult(String result) {
        System.out.println(GAME_RESULT_MESSAGE);
        System.out.println(result);
        System.out.println();
    }

    public static void printPlayerResultAll(Map<String, String> result) {
        System.out.println(GAME_RESULT_MESSAGE);
        for (String player : result.keySet()) {
            System.out.println(player + " : " + result.get(player));
        }
    }
}
