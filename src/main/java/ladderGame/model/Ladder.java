package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public void descendLadder(Players players) {
        lines.forEach(line -> players.move(line));
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
