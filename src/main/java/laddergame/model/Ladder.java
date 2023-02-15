package laddergame.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Height height;
    private final List<Line> ladder;

    public Ladder(Height height, Persons persons) {
        this.height = height;
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < this.height.getHeight(); i++) {
            ladder.add(new Line(persons.getSize()));
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
