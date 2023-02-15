package utils;

import static utils.constants.ErrorMessages.*;
import static utils.constants.GameRules.*;
import static utils.constants.LadderFormat.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.Ladder;
import domain.LadderRow;

public class StringParser {

    public static final String SPLIT_DELIMITER = ",";
    public static final int SPLIT_LIMIT = -1;
    public static final int ZERO = 0;

    public static List<String> splitByComma(String input) {
        return Arrays.asList(input.split(SPLIT_DELIMITER, SPLIT_LIMIT));
    }

    public static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMBER_FORMAT.getMessage(), exception);
        }
    }

    public static String putBlank(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ".repeat(Math.max(ZERO, MAX_NAME_LENGTH.getValue()) - input.length()));
        stringBuilder.append(input);
        return stringBuilder.toString();
    }

    public static List<String> parseLadderToString(Ladder ladder) {
        List<LadderRow> lines = ladder.getLadderRows();
        return lines.stream()
                .map(StringParser::parseLineToString)
                .collect(Collectors.toUnmodifiableList());
    }

    private static String parseLineToString(LadderRow line) {
        List<Boolean> existedLine = line.getLines();
        List<String> parsedLine = existedLine.stream()
                .map(StringParser::convertLineStatus)
                .collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder(START_DELIMITER.getFormat());
        stringBuilder.append(String.join(DELIMITER.getFormat(), parsedLine));
        stringBuilder.append(DELIMITER.getFormat());
        return stringBuilder.toString();
    }

    private static String convertLineStatus(boolean existed) {
        if (existed) {
            return EXISTED_LINE.getFormat();
        }
        return NON_EXISTED_LINE.getFormat();
    }
}
