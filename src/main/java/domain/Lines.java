package domain;

import domain.line.Line;

import java.util.List;
import java.util.stream.IntStream;

public class Lines {
    private final int height;
    private final int personCount;
    private final BooleanGenerator generator = new RandomBooleanGenerator();

    public Lines(final int height, final int personCount) {
        this.height = height;
        this.personCount = personCount;
    }

    public List<Line> getLines() {
        return createLines();
    }

    private List<Line> createLines() {
        return IntStream.range(0, height)
                .mapToObj(index -> new Line(personCount, generator))
                .toList();
    }
}
