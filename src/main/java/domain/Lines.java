package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public Lines(final int height, final int personCount, final PointGenerator generator) {
        createLines(height, personCount, generator);
    }

    private void createLines(final int height, final int personCount, final PointGenerator generator) {
        IntStream.range(0, height)
                .mapToObj(index -> new Line(personCount, generator))
                .forEach(lines::add);
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Integer> getAllMovablePoints() {
        return lines.stream()
                .map(Line::getMovablePointIndexes)
                .flatMap(List::stream)
                .toList();
    }
}
