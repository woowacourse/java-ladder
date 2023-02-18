package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bars {

    private final List<Boolean> bars = new ArrayList<>();
    private final RandomGenerator randomGenerator;

    public Bars(RandomGenerator randomPointGenerator, int count) {
        randomGenerator = randomPointGenerator;
        initialize(count);
    }

    private void initialize(int count) {
        boolean previousValue = false;

        for (int i = 0; i < count; i++) {
            Boolean generatedBar = randomGenerator.generate(previousValue);
            bars.add(generatedBar);
            previousValue = generatedBar;
        }
    }

    public List<Boolean> toUnmodifiableBars() {
        return Collections.unmodifiableList(bars);
    }
}
