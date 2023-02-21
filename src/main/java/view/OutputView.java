package view;

import domain.Line;
import domain.Name;
import java.util.List;

public class OutputView {
    private static final String BRIDGE = "-----";
    private static final String VERTICAL_LINE = "|";
    private static final String BLANK_LINE = "     ";
    private static final String BLANK = " ";
    private static final String PLAY_RESULT = "실행 결과";

    public void printLadder(List<Line> lines){
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < lines.size(); index++) {
            appendLine(builder, lines.get(index));
            appendNewLine(lines, builder, index);
        }
        System.out.println(builder);
    }

    private static void appendNewLine(List<Line> lines, StringBuilder builder, int index) {
        if (index != lines.size() - 1) {
            builder.append("\n");
        }
    }

    public void printPlayersName(List<String> names){
        StringBuilder stringBuilder = new StringBuilder();

        for (String name : names) {
            stringBuilder.append(name)
                    .append(getNameBlank(name))
                    .append(BLANK);
        }
        System.out.println(stringBuilder);
    }

    private void appendLine(StringBuilder builder, Line line) {
        builder.append(VERTICAL_LINE);
        for (int pointIndex = 0; pointIndex < line.getPointsSize(); pointIndex++) {
            appendPoint(builder, line, pointIndex);
        }
    }

    private void appendPoint(StringBuilder builder, Line line, int pointIndex) {
        if (line.isMovablePoint(pointIndex)) {
            builder.append(BRIDGE);
        }
        if (!line.isMovablePoint(pointIndex)) {
            builder.append(BLANK_LINE);
        }
        builder.append(VERTICAL_LINE);
    }

    private String getNameBlank(String name) {
        return BLANK.repeat(Name.NAME_MAX_LENGTH - name.length());
    }

    public void printResults(List<String> results) {
        StringBuilder stringBuilder = new StringBuilder();

        for(String result : results){
            stringBuilder.append(result)
                    .append(getNameBlank(result))
                    .append(BLANK);
        }
        System.out.println(stringBuilder);
    }

    public void printPlayResult(String result) {
        System.out.println("\n" + PLAY_RESULT);
        System.out.println(result);
    }
}
