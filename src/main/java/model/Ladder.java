package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(Height height, int peopleCount, RandomGenerator randomGenerator) {
        generateLadder(height, peopleCount, randomGenerator);
    }

    public void generateLadder(Height height, int totalStateAmount, RandomGenerator randomGenerator) {
        int count = 0;
        while (!height.isDesignatedHeight(count)) {
            List<Boolean> makeLadderOrNot = randomGenerator.generate(totalStateAmount - 1);
            lines.add(new Line(makeLadderOrNot));
            count++;
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
