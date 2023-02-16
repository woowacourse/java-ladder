package domain;

import static utils.constants.LadderFormat.DELIMITER;
import static utils.constants.LadderFormat.EXISTED_LINE;
import static utils.constants.LadderFormat.NON_EXISTED_LINE;
import static utils.constants.LadderFormat.START_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;

public class LadderRow {
    List<Boolean> lines;

    public LadderRow(List<Boolean> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(List<Boolean> lines) {
        boolean flag = false;
        for (int i = 0; i < lines.size() - 1; i++) {
            Boolean current = lines.get(i);
            Boolean next = lines.get(i + 1);
            if (current == next && current) {
                flag = true;
                break;
            }
        }
        if (flag) {
            throw new IllegalArgumentException();
        }
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
        return lines.stream()
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
