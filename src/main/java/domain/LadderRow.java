package domain;

import static view.LadderFormat.DELIMITER;
import static view.LadderFormat.EXISTED_LINE;
import static view.LadderFormat.NON_EXISTED_LINE;
import static view.LadderFormat.START_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;

public class LadderRow {
    List<Boolean> bars;

    public LadderRow(List<Boolean> lines) {
        validate(lines);
        this.bars = lines;
    }

    private void validate(List<Boolean> lines) {
        int limit = lines.size() - 1;
        for (int i = 0; i < limit; i++) {
            Boolean current = lines.get(i);
            Boolean next = lines.get(i + 1);
            checkIsTrueInRow(current, next);
        }
    }

    private void checkIsTrueInRow(Boolean current, Boolean next) {
        if (isAllTrue(current, next)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isAllTrue(Boolean current, Boolean next) {
        return current == next && current;
    }

    public String parseLineToString() {
        List<String> parsedLine = getParsedLine();
        return formatParsedLine(parsedLine);
    }

    private static String formatParsedLine(List<String> parsedLine) {
        StringBuilder stringBuilder = new StringBuilder(START_DELIMITER.getFormat());
        stringBuilder.append(String.join(DELIMITER.getFormat(), parsedLine));
        stringBuilder.append(DELIMITER.getFormat());
        return stringBuilder.toString();
    }

    private List<String> getParsedLine() {
        return bars.stream()
                .map(this::convertLineStatus)
                .collect(Collectors.toList());
    }

    private String convertLineStatus(boolean existed) {
        if (existed) {
            return EXISTED_LINE.getFormat();
        }
        return NON_EXISTED_LINE.getFormat();
    }
}
