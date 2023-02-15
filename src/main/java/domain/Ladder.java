package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int personCount, int maxHeight, BridgeGenerator generator) {
        this.lines = new ArrayList<>(maxHeight);
        for (int i = 0; i < maxHeight; i++) {
            lines.add(new Line(generator.generate(personCount)));
        }
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
