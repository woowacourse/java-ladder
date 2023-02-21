package ladder.domain;

import ladder.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int countOfParticipants, Height height, BooleanGenerator generator) {
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.add(new Line(countOfParticipants, generator));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
