package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();
    private final BooleanGenerator booleanGenerator;

    public Line(final int personCount, final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
        for (int position = 0; position < personCount - 1; position++) {
            points.add(decideConnection(position));
        }
    }

    private Boolean decideConnection(int position) {
        if (position == 0) {
            return booleanGenerator.generate();
        }
        if (points.get(position - 1) == Boolean.TRUE) {
            return Boolean.FALSE;
        }
        return booleanGenerator.generate();
    }

    public List<Boolean> getLineStatus() {
        return new ArrayList<>(points);
    }
}
