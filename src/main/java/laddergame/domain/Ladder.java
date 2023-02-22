package laddergame.domain;

import laddergame.vo.Position;

import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = List.copyOf(lines);
    }

    public List<Line> getLadder() {
        return lines;
    }

    public Position getArrivalPosition(Position startPosition) {
        Position currentPosition = startPosition;
        for (Line line : lines) {
            currentPosition = line.getConnectedPosition(currentPosition);
        }
        return currentPosition;
    }
}
