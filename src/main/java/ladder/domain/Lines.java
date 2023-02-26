package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {

    private final RandomGenerator<Boolean> randomPointGenerator;
    private final List<Line> lines = new ArrayList<>();

    public Lines(final int height, final int width) {
        this.randomPointGenerator = new RandomBooleanGenerator();
        initialize(height, width);
    }

    public Lines(final RandomGenerator<Boolean> randomGenerator, final int height, final int width) {
        this.randomPointGenerator = randomGenerator;
        initialize(height, width);
    }

    private void initialize(final int height, final int width) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(randomPointGenerator, width));
        }
    }

    public List<Line> toUnModifiableLines() {
        return Collections.unmodifiableList(lines);
    }
}
