package view.formatter;

import dto.LineDto;
import java.util.List;

public class LineDtoFormatter {

    public static String format(final LineDto lineDto) {
        List<Boolean> line = lineDto.lineInfo();
        String formattedLine = " ".repeat(4) + "|";
        for (Boolean isPath : line) {
            formattedLine += formatPath(isPath);
        }
        return formattedLine;
    }

    private static String formatPath(final Boolean isPath) {
        if (isPath) {
            return "-".repeat(5) + "|";
        }
        return " ".repeat(5) + "|";
    }
}
