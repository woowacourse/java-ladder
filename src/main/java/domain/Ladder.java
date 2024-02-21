package domain;

import utils.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    List<Line> lines = new ArrayList<>();

    public Ladder(int floor, int participantsCount) {
        Height height = new Height(floor);
        for (int i = 0; i < floor; i++) {
            lines.add(new Line(participantsCount - 1, new RandomBooleanGenerator()));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
