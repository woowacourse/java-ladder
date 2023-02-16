package view;

import domain.Line;
import domain.Person;
import java.util.List;

public class OutputView {
    private static final String BRIDGE = "-----";
    private static final String VERTICAL_LINE = "|";
    private static final String BLANK_LINE = "     ";
    private static final String BLANK = " ";

    public void printLadder(List<Line> lines){
        StringBuilder builder = new StringBuilder();

        for (Line line : lines) {
            printLine(builder, line);
        }
        System.out.println(builder);
    }

    private void printLine(StringBuilder builder, Line line) {
        builder.append(VERTICAL_LINE);
        for (int pointIndex = 0; pointIndex < line.getPointsSize(); pointIndex++) {
            printPoint(builder, line, pointIndex);
        }
        builder.append("\n");
    }

    private void printPoint(StringBuilder builder, Line line, int pointIndex) {
        if (line.isMovablePoint(pointIndex)) {
            builder.append(BRIDGE);
        }
        if (!line.isMovablePoint(pointIndex)) {
            builder.append(BLANK_LINE);
        }
        builder.append(VERTICAL_LINE);
    }

    public void printPersonNames(List<String> names){
        StringBuilder stringBuilder = new StringBuilder();

        for(String name : names){
            stringBuilder.append(name)
                    .append(getNameBlank(name))
                    .append(BLANK);
        }
        System.out.println(stringBuilder);
    }

    private String getNameBlank(String name) {
        return BLANK.repeat(Person.NAME_MAX_LENGTH - name.length());
    }
}
