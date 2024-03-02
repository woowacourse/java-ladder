package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();
    private final int width;

    public Ladder(Height height, int playerSize, StickGenerator stickGenerator) {
        int heightValue = height.getValue();

        for (int i = 0; i < heightValue; i++) {
            lines.add(new Line(stickGenerator, playerSize));
        }

        this.width = playerSize;
    }

    public Column climb(Column playerColumn) {
        Column column = new Column(playerColumn.getValue());

        for (Line line : lines) {
            column = column.change(line.move(column));
        }

        return column;
    }

    public int widthSize() {
        return width;
    }

    public List<Line> getLines() {
        return lines;
    }
}
