package ladder.domain;

import ladder.util.RandomPointsGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(People people, Height height) {
        RandomPointsGenerator randomPointsGenerator = new RandomPointsGenerator(new Random());
        int personCount = people.count();

        while (!height.isSame(lines.size())) {
            Line line = new Line(personCount, randomPointsGenerator);
            lines.add(line);
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(lines);
    }
}
