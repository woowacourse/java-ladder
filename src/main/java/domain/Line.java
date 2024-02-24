package domain;

import util.LineItemGenerator;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<LineItem> points;
    private final int columnLength;

    public Line(int columnLength) {
        this.points = new ArrayList<>();
        this.columnLength = columnLength;
    }

    public List<LineItem> makeLine(LineItemGenerator lineItemGenerator) {
        for (int position = 0; position < columnLength - 1; position++) {
            LineItem lineItem = lineItemGenerator.generate();

            points.add(decideLineItem(position, lineItem));
        }

        return points;
    }

    public LineItem decideLineItem(int position, LineItem lineItem) {
        if (position == 0 || points.get(position - 1).equals(LineItem.UNCONNECTED)) {
            return lineItem;
        }

        return LineItem.UNCONNECTED;
    }

    public List<LineItem> getPoints() {
        return points;
    }
}
