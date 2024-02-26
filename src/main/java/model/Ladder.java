package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(Height height, int peopleCount, RandomGenerator randomGenerator) {
        generateLine(height, peopleCount, randomGenerator);
    }

    public void generateLine(Height height, int peopleCount, RandomGenerator randomGenerator) {
        int count = 0;
        while (!height.isDesignatedHeight(count)) {
            List<Boolean> generatedResult = randomGenerator.generate(peopleCount);
            lines.add(new Line(peopleCount, generatedResult));
            count++;
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
