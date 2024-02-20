package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(final int playerCount) {
        List<Boolean> tempPoints = new ArrayList<>();
        IntStream.range(0, playerCount).forEach(i -> tempPoints.add(Boolean.FALSE));
        this.points = tempPoints;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
