package formatter;

import java.util.List;

public class LineFormatter {

    private static final String INITIAL_BLANKS = " ".repeat(4);
    private static final String VERTICAL_LINE = "|";
    private static final String NOT_EXIST_PATH = " ".repeat(5);
    private static final String EXIST_PATH = "-".repeat(5);

    public static String format(final List<Boolean> line) {
        StringBuilder formattedLine = new StringBuilder(INITIAL_BLANKS + VERTICAL_LINE);
        for (Boolean isExist : line) {
            formattedLine.append(getPathFormat(isExist));
            formattedLine.append(VERTICAL_LINE);
        }
        return formattedLine.toString();

    }

    private static String getPathFormat(final Boolean isExist) {
        if (isExist) {
            return EXIST_PATH;
        }
        return NOT_EXIST_PATH;
    }
}
