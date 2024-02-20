package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(final int personSize, final BooleanGenerator booleanGenerator) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < personSize - 1; i++) {
            points.add(booleanGenerator.generate());
        }

        this.points = points;
    }

    public int getSize() {
        return points.size();
    }
}
