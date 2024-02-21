package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public void generateLine(int height, int peopleCount, RandomGenerator randomGenerator) {
        for (int i = 0; i < height; i++) {
            List<Boolean> generatedResult = randomGenerator.generate(peopleCount);
            lines.add(new Line(peopleCount, generatedResult));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
