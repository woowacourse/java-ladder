package view;

import domain.Line;
import java.util.List;

public class LadderView {

    public static String createLadder(List<Line> lines) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : lines) {
            stringBuilder.append(createLine(line.getLineItems()));
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private static String createLine(List<LineItem> lineItems) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    |");
        for (LineItem lineItem : lineItems) {
            stringBuilder.append(lineItem.getShape());
        }
        return stringBuilder.toString();
    }
}
