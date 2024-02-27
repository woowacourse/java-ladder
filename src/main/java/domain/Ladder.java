package domain;

import domain.booleangenerator.BooleanGenerator;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(Players players, Height height, BooleanGenerator booleanGenerator) {
        this.lines = IntStream.range(0, height.getHeight())
                .mapToObj(number -> new Line(players.getTotalPlayerSize(), booleanGenerator))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
