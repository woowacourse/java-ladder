package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Line> lines;
    public Ladder(Height height, int personCount) {
        lines = new ArrayList<>();
        for(int i = 0; i < height.getValue(); i++) {
            lines.add(new Line(personCount));
        }
    }

    public int size() {
        return lines.size();
    }

    public int width() {
        return lines.get(0).size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
