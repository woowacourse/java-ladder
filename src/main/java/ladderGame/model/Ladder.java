package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int maxHeight, int personNumber) {
        lines = Stream.generate(() -> new Line(new RandomBooleanGenerator(), personNumber)).limit(maxHeight).toList();
    }

    public void descendLadder(Players players) {
        for(Line line : lines) {
            players.move(line);
        }
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
