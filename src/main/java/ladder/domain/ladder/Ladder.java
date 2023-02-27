package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(BarGenerator barGenerator, int ladderHeight, int peopleSize) {
        this.lines = createLines(barGenerator, ladderHeight, peopleSize);
    }

    private List<Line> createLines(BarGenerator barGenerator, int ladderHeight, int peopleSize) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(lineCount -> createLine(barGenerator, peopleSize))
                .collect(Collectors.toUnmodifiableList());
    }

    private Line createLine(BarGenerator barGenerator, int peopleSize) {
        Line line = new Line();
        line.addBars(peopleSize, barGenerator);
        return line;
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
