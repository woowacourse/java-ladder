package ladder.domain;

import ladder.util.RandomPointsGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(People people, Height height) {
        RandomPointsGenerator randomPointsGenerator = new RandomPointsGenerator();

        while (!height.isSame(lines.size())) {
            Line line = new Line(people.count(), randomPointsGenerator);
            lines.add(line);
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(lines);
    }
}
