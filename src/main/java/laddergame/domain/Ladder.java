package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final int playerCount, final int height) {
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(playerCount))
                .collect(Collectors.toList());
    }

    public void build(final List<List<Boolean>> isBridgesBuilt) {
        IntStream.range(0, lines.size())
                .forEach(i -> lines.get(i).buildBridge(isBridgesBuilt.get(i)));
    }

    public List<Line> getLines() {
        return lines;
    }
}
