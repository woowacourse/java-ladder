package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Line> lines;

    public Ladder() {
        this.lines = new ArrayList<>();
    }

    public Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public boolean addLines(final Line line) {
        return lines.add(line);
    }

    public int takeLadder(int point) {
        for (Line line : lines) {
            point = line.moveNextPoint(point);
        }
        return point;
    }

    public List<Line> getLines() {
        return lines;
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
