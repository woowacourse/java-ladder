package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public void generateLine(int height, int peopleCount, List<List<Boolean>> booleans) {
        for (int i = 0; i < height; i++) {
            List<Boolean> generatedResult = booleans.get(i);
            lines.add(new Line(peopleCount, generatedResult));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
