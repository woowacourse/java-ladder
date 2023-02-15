package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Points {

    private final List<Boolean> points = new ArrayList<>();
    private final RandomGenerator randomGenerator;

    public Points(RandomGenerator randomPointGenerator, int count) {
        randomGenerator = randomPointGenerator;
        initialize(count);
    }

    private void initialize(int count) {
        Boolean flag = false;

        for (int i = 0; i < count; i++) {
            Boolean generate = generatePoint(flag);
            points.add(generate);
            flag = generate;
        }
    }

    private Boolean generatePoint(boolean before) {
        if (before) {
            return false;
        }
        return randomGenerator.generate();
    }

    public List<Boolean> toUnmodifiablePoints() {
        return Collections.unmodifiableList(points);
    }
}
