package laddergame.model.ladder;

import java.util.ArrayList;
import java.util.List;
import laddergame.model.people.People;

public class Ladder {
    private final Height height;
    private final List<Line> ladder;

    public Ladder(Height height, People people) {
        this.height = height;
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < this.height.getHeight(); i++) {
            ladder.add(new Line(people.getSize()));
        }
        this.ladder = ladder;
    }

    public int getSize() {
        return ladder.size();
    }

    public Line get(int i) {
        return ladder.get(i);
    }
}
