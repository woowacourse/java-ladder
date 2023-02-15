package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder() {
        this.lines = new ArrayList<>();
    }

    public void create(BarGenerator barGenerator, int ladderHeight, int peopleSize) {
        IntStream.range(0, ladderHeight)
                .mapToObj(lineCount -> createLine(barGenerator, peopleSize))
                .forEach(lines::add);
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
