package model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import model.Index;
import model.line.Line;
import model.line.LinesGenerator;
import model.people.PersonCount;

public class Ladder {
    private final List<Line> lines;
    private final Height height;

    private Ladder(final List<Line> lines, final Height height) {
        this.lines = lines;
        this.height = height;
    }

    public static Ladder from(final Height height, final PersonCount personCount, final LinesGenerator linesGenerator) {
        int pathCount = personCount.getCount() - 1;
        final List<Line> lines = linesGenerator.generate(height, pathCount);
        return new Ladder(lines, height);
    }

    public Index climb(final Index startIndex) {
        Index currentIndex = startIndex;
        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }
        return currentIndex;
    }

    public List<Index> climbAll() {
        return IntStream.range(0, findPersonCount())
                .mapToObj(Index::new)
                .map(this::climb)
                .toList();
    }

    private int findPersonCount() {
        Line line = lines.get(0);
        return line.getPathsSize() + 1;
    }

    public List<Line> getLines() {
        return lines;
    }
}
