package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(People people, Height height) {
        RandomPointsGenerator randomPointsGenerator = new RandomPointsGenerator(new Random());
        int personCount = people.count();

        while (!height.equals(lines.size())) {
            Line line = new Line(personCount, randomPointsGenerator);
            lines.add(line);
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(lines);
    }
}
