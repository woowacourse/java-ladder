package formatter;

import java.util.List;

public class LineFormatter {

    public static String format(List<Boolean> line) {
        // TODO : 끝내주는 리팩토링 하기
        String formattedLine = " ".repeat(4) + "|";
        for (Boolean isPath : line) {
            if (isPath) {
                formattedLine += "-".repeat(5) + "|";
                continue;
            }
            formattedLine += " ".repeat(5) + "|";
        }
        return formattedLine;
    }
}
