package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.Generator;

public class Ladder {

    private final List<Line> ladder;
    private final Height height;

    public Ladder(Height height) {
        this.height = height;
        this.ladder = new ArrayList<>();
    }

    public void init(int personCount, Generator generator) {
        for (int index = 0; index < height.getHeight(); ++index) {
            ladder.add(index, new Line(generator.generate(personCount)));
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
