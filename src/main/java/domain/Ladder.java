package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(PlayerNumber playerNumber, Height height) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, playerNumber.getLineNumber())
                .forEach(it -> lines.add(Line.fromHeight(height)));

        return new Ladder(lines);
    }

    public void buildBridge(int y, int x) {
        lines.get(x).getPoints().get(y).changeDirection(Direction.RIGHT_DOWN);
        lines.get(x + 1).getPoints().get(y).changeDirection(Direction.LEFT_DOWN);
    }

    public Point getPoint(int y, int x) {
        return lines.get(x).getPoints().get(y);
    }

    public List<Line> getLines() {
        return lines;
    }
}
