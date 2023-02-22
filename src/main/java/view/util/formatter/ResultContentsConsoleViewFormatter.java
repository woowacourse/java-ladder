package view.util.formatter;

import domain.ResultContent;
import domain.ResultContents;

public class ResultContentsConsoleViewFormatter {

    private static final String BLANK = " ";

    public static String formatResultContents(ResultContents resultContents) {
        StringBuilder playersFormat = new StringBuilder();

        for (ResultContent resultContent : resultContents.getResultContents()) {
            playersFormat.append(LadderContentConsoleViewFormatter.formatContent(resultContent.getContent()))
                    .append(BLANK);
        }

        return playersFormat.toString();
    }
}
