package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bars {

    private final List<Boolean> points = new ArrayList<>();
    private final RandomGenerator randomGenerator;

    public Bars(RandomGenerator randomPointGenerator, int count) {
        randomGenerator = randomPointGenerator;
        initialize(count);
    }

    private void initialize(int count) {
        Boolean flag = false;

        for (int i = 0; i < count; i++) {
            Boolean generate = randomGenerator.generate(flag);
            points.add(generate);
            flag = generate;
        }
    }

    public List<Boolean> toUnmodifiableBars() {
        return Collections.unmodifiableList(points);
    }
}
