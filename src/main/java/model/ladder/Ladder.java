package model.ladder;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import model.line.LineGenerator;
import model.line.Line;
import model.player.Players;

public class Ladder {
    private static final int LINE_WIDTH_OFFSET = 1;

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(LadderHeight height, Players players, LineGenerator LineGenerator) {
        int lineWidth = players.getSize() - LINE_WIDTH_OFFSET;
        return IntStream.range(0, height.value())
                .mapToObj(i -> LineGenerator.generateLine(lineWidth))
                .collect(collectingAndThen(toList(), Ladder::new));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
