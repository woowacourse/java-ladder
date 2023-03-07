package laddergame.model.ladder;

import java.util.ArrayList;
import java.util.List;
import laddergame.model.people.People;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Height height, People people) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(people.size()));
        }
        this.lines = lines;
    }

    public int getHeight() {
        return lines.size();
    }

    public Line getLine(int i) {
        return lines.get(i);
    }
}
