package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public void connect(LadderBuildingStrategy strategy, int lineNumber, int point) {
        lines.get(lineNumber).connect(strategy, point);
    }

    public Line getLine(int lineNumber) {
        return lines.get(lineNumber);
    }

    public int getHeight() {
        return lines.size();
    }

    public int getNumberOfPeople() {
        return lines.get(0).getNumberOfPeople();
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
