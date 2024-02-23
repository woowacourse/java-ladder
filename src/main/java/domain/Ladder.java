package domain;

import java.util.stream.IntStream;

import java.util.ArrayList;
import java.util.List;
import utils.RandomStepGenerator;
import utils.StepGenerator;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int floor, int participantsCount) {
        int stepPointCount = participantsCount - 1;
        StepGenerator stepGenerator = new RandomStepGenerator();
        Height height = new Height(floor);
        lines = new ArrayList<>();

        IntStream.range(0, floor)
                .mapToObj(i -> new Line(stepPointCount, stepGenerator))
                .forEach(lines::add);
    }

    public List<Line> getLines() {
        return lines;
    }
}
