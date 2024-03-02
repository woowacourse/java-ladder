package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(Height height, int playerSize, StickGenerator stickGenerator) {
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(new Line(stickGenerator, playerSize));
        }
    }

    public Column climb(Column playerColumn) {
        Column column = new Column(playerColumn.getValue());

        for (Line line : lines) {
            column = column.change(line.move(column));
        }

        return column;
    }

    public List<Line> getLines() {
        return lines;
    }
}
