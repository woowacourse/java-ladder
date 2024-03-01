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

    public int climb(int playerColumn) {
        int nowColumn = playerColumn;

        for (Line line : lines) {
            nowColumn = calculateNowColumn(nowColumn, line);
        }

        return nowColumn;
    }

    private int calculateNowColumn(int nowColumn, Line line) {
        Direction direction = line.move(nowColumn);

        if (direction.isLeft()) {
            nowColumn--;
        }

        if (direction.isRight()) {
            nowColumn++;
        }

        return nowColumn;
    }

    public List<Line> getLines() {
        return lines;
    }
}
