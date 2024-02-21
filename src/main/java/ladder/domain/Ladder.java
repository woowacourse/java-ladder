package ladder.domain;

import ladder.util.RandomBooleanListGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;


    public Ladder(int height, int personCount) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(personCount, new RandomBooleanListGenerator()));
        }
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
