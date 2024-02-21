package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int maxHeight, int personNumber) {
        lines = new ArrayList<>();
        for (int i = 0; i < maxHeight; i++) {
            lines.add(new Line(personNumber));
        }
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
