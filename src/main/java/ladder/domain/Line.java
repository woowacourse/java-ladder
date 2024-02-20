package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;

public class Line {
    private final List<Boolean> points;

    public Line(final int userCount) {
        this.points = initPoints(userCount);
    }

    private List<Boolean> initPoints(final int userCount) {
        final List<Boolean> points = new ArrayList<>(userCount - 1);
        IntStream.rangeClosed(1, userCount - 1)
                .forEach(i -> points.add(false));
        return points;
    }

    public List<Boolean> getPoints() {
        return unmodifiableList(points);
    }
}
