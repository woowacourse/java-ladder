package ladder.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generate(int countOfLine, int countOfBar, BooleanGenerator booleanGenerator) {
        return Stream.generate(() -> Line.generate(countOfBar, booleanGenerator))
                .limit(countOfLine)
                .collect(collectingAndThen(toList(), Ladder::new));
    }

    public Position getResultPosition(Position position) {
        for (Line line : lines) {
            Direction direction = line.getDirection(position);
            position.move(direction);
        }
        return position;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
