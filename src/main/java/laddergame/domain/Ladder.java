package laddergame.domain;

import laddergame.domain.rule.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder(int numberOfPlayer, int height, Rule rule) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(numberOfPlayer, rule));
        }
    }

    public Line getLine(int height) {
        return lines.get(height);
    }

    public int getHeight() {
        return lines.size();
    }

    public int takeLadder(int point) {
        for (Line line : lines) {
            point = line.moveNextPoint(point);
        }
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
