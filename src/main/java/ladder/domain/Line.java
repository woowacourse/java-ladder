package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(final int width, final BooleanGenerator booleanGenerator) {
        this.points = new ArrayList<>();
        for (int position = 0; position < width; position++) {
            points.add(decideConnection(position, booleanGenerator));
        }
    }

    private Boolean decideConnection(int position, BooleanGenerator booleanGenerator) {
        if (position == 0) {
            return booleanGenerator.generate();
        }
        if (points.get(position - 1) == Boolean.TRUE) {
            return Boolean.FALSE;
        }
        return booleanGenerator.generate();
    }

    public List<Boolean> getLineStatus() {
        return List.copyOf(points);
    }
}
