package model.ladder;

import java.util.ArrayList;
import java.util.List;
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

    public int climb(final int startIndex) {
        int currentIndex = startIndex;
        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }
        return currentIndex;
    }

    public List<Integer> climbAll() {
        List<Integer> resultIndexes = new ArrayList<>();
        int index = 0;
        while (index < findPersonCount()) {
            int resultIndex = climb(index);
            resultIndexes.add(resultIndex);
            index++;
        }
        return resultIndexes;
    }

    private int findPersonCount() {
        Line line = lines.get(0);
        return line.getPathsSize() + 1;
    }

    public List<Line> getLines() {
        return lines;
    }
}
