package domain;

import utils.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final Height height;
    private final List<Line> lines;

    public Ladder(int floor, int participantsCount) {
        lines = new ArrayList<>();
        height = new Height(floor);
        for (int i = 0; i < floor; i++) {
            lines.add(new Line(participantsCount - 1, new RandomBooleanGenerator()));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
