package model.ladder;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import model.line.Line;
import model.line.LineGenerator;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder of(LadderHeight height, LadderWidth ladderWidth,
        LineGenerator lineGenerator) {
        return IntStream.range(0, height.getValue())
            .mapToObj(i -> lineGenerator.generateLine(ladderWidth.getValue()))
            .collect(collectingAndThen(toList(), Ladder::new));
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getWidth() {
        return lines.get(0).getSize();
    }
}
