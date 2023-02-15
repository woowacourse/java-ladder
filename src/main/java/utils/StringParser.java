package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.Ladder;
import domain.Line;

public class StringParser {
    public static List<String> splitByComma(String input) {
        return Arrays.asList(input.split(",", -1));
    }

    public static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("정수만 입력가능합니다.");
        }
    }

    public static String putBlank(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5 - input.length(); i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(input);
        return stringBuilder.toString();
    }

    public static List<String> parseLadderToString(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        return lines.stream()
                .map(StringParser::parseLineToString)
                .collect(Collectors.toUnmodifiableList());
    }

    private static String parseLineToString(Line line) {
        List<Boolean> existedLine = line.getExistedLine();
        List<String> parsedLine = existedLine.stream()
                .map(StringParser::convertLineStatus)
                .collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder("    |");
        stringBuilder.append(String.join("|", parsedLine));
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    private static String convertLineStatus(boolean existed) {
        if (existed) {
            return "-----";
        }
        return "     ";
    }
}
