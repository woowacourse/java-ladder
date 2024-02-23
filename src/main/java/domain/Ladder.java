package domain;

import utils.RandomStepGenerator;
import utils.StepGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final Height height;
    private final List<Line> lines;

    public Ladder(int floor, int participantsCount) {
        height = new Height(floor);
        lines = new ArrayList<>();
        int stepPointCount = participantsCount - 1;
        StepGenerator stepGenerator = new RandomStepGenerator();
        IntStream.range(0, floor)
                .mapToObj(i -> new Line(stepPointCount, stepGenerator))
                .forEach(lines::add);
    }

    public List<Line> getLines() {
        return lines;
    }
}
