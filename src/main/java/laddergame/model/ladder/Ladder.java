package laddergame.model.ladder;

import java.util.ArrayList;
import java.util.List;
import laddergame.model.people.People;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(Height height, People people) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.add(new Line(people.size()));
        }
        this.ladder = ladder;
    }

    public int size() {
        return ladder.size();
    }

    public List<Point> getLineToListPoint(int i) {
        return ladder.get(i).getLine();
    }

    public Line getLine(int i) {
        return ladder.get(i);
    }
}
