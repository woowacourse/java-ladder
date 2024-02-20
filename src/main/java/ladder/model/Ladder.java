package ladder.model;

import ladder.utils.RandomBooleanGenerator;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder from(LadderHeight height, int width) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.add(Line.of(width, new RandomBooleanGenerator()));
        }
        return new Ladder(ladder);
    }

    public int getHeight() {
        return ladder.size();
    }

    public int getWidth() {
        return ladder.get(0).size();
    }
}
