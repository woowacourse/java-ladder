package ladder.domain;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import ladder.utils.RandomGenerator;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generate(int countOfLine, int countOfBar, RandomGenerator randomGenerator) {
        return Stream.generate(() -> new Line(countOfBar, randomGenerator))
                .limit(countOfLine)
                .collect(collectingAndThen(toList(), Ladder::new));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
