package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;

        if (isConsecutive()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isConsecutive() {
        return Collections.indexOfSubList(points, Arrays.asList(true, true)) != -1;
    }
}
