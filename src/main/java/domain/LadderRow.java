package domain;

import utils.constants.ErrorMessages;

import java.util.List;
import java.util.stream.Collectors;

import static utils.constants.ErrorMessages.*;
import static utils.constants.LadderFormat.*;

public class LadderRow {

    private final List<Boolean> lines;

    public LadderRow(final List<Boolean> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(final List<Boolean> lines) {
        for (int i = 0; i < lines.size() - 1; i++) {
            isAllTrue(lines.get(i), lines.get(i + 1));
        }
    }

    private void isAllTrue(boolean current, boolean next) {
        if (current && next) {
            throw new IllegalArgumentException(CONSECUTIVE_LINE.getMessage());
        }
    }

    public String parseLineToString() {
        List<String> parsedLine = getParsedLine();
        return formatParsedLine(parsedLine);
    }

    private String formatParsedLine(final List<String> parsedLine) {
        StringBuilder stringBuilder = new StringBuilder(START_DELIMITER.getFormat());
        stringBuilder.append(String.join(DELIMITER.getFormat(), parsedLine));
        stringBuilder.append(DELIMITER.getFormat());
        return stringBuilder.toString();
    }

    private List<String> getParsedLine() {
        return lines.stream()
                .map(this::convertLineStatus)
                .collect(Collectors.toList());
    }

    private String convertLineStatus(final boolean existed) {
        if (existed) {
            return EXISTED_LINE.getFormat();
        }
        return NON_EXISTED_LINE.getFormat();
    }
}
