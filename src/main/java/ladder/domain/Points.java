package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Points {

    private final List<Boolean> points = new ArrayList<>();

    public Points(RandomGenerator randomPointGenerator, int count) {
        initialize(randomPointGenerator, count);
    }

    private void initialize(RandomGenerator randomPointGenerator, int count) {
        for (int i = 0; i < count; i++) {
            points.add(randomPointGenerator.generate());
        }
    }

    public List<Boolean> toUnmodifiablePoints() {
        return Collections.unmodifiableList(points);
    }
}
