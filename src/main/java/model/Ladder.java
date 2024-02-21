package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines;
    public Ladder(int height, int personCount) {
        lines = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            lines.add(new Line(personCount));
        }
    }

    public int size() {
        return lines.size();
    }
}
