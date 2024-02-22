package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import laddergame.dto.LineBuildResult;

public class Ladder {
    private final List<Line> lines;
    private final Height height;

    public Ladder(final int playerCount, final Height height) {

        this.height = height;
        this.lines = IntStream.range(0, this.height.getHeight())
                .mapToObj(i -> new Line(playerCount))
                .collect(Collectors.toList());
    }



    public void build(final List<LineBuildResult> isBridgesBuilt) {
        IntStream.range(0, lines.size())
                .forEach(i -> lines.get(i).buildBridge(isBridgesBuilt.get(i)));
    }

    public List<Line> getLines() {
        return lines;
    }
}
