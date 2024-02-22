package formatter;

import java.util.List;

public class LineFormatter {

    public static String format(List<Boolean> line) {
        String formattedLine = " ".repeat(4) + "|";
        for (Boolean isPath : line) {
            formattedLine += formatPath(isPath);
        }
        return formattedLine;
    }

    private static String formatPath(Boolean isPath) {
        if (isPath) {
            return "-".repeat(5) + "|";
        }
        return " ".repeat(5) + "|";
    }
}
