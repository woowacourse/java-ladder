package domain;

import java.util.stream.IntStream;
import utils.BooleanGenerator;
import utils.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int floor, int participantsCount) {
        int stepPointCount = participantsCount - 1;
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        Height height = new Height(floor);
        lines = new ArrayList<>();

        IntStream.range(0, floor)
                .mapToObj(i -> new Line(stepPointCount, booleanGenerator))
                .forEach(lines::add);
    }

    public List<Line> getLines() {
        return lines;
    }
}
