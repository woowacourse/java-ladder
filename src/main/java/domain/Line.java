package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line fromHeight(Height height) {
        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, height.getHeight())
                .forEach(i -> points.add(false));

        return new Line(points);
    }

    public List<Boolean> getPoints() {
        return this.points;
    }

    public void createHorizontalLineAt(int index) {
        this.points.set(index - 1, true);
    }

    public boolean existHorizontalLineAt(int index) {
        return points.get(index - 1);
    }
}
