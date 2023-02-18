package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {

    private static final RandomGenerator<Boolean> randomPointGenerator = new RandomBooleanGenerator();
    private final List<Line> lines = new ArrayList<>();

    public Lines(final int height, final int width) {
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
