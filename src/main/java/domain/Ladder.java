package domain;

import java.util.List;
import java.util.stream.Stream;
import utils.RandomStepGenerator;
import utils.StepGenerator;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int floor, int participantsCount) {
        int stepPointCount = participantsCount - 1;
        StepGenerator stepGenerator = new RandomStepGenerator();
        Height height = new Height(floor);
        lines = Stream.generate(() -> new Line(stepPointCount, stepGenerator))
                .limit(floor)
                .toList();
    }

    public List<Line> getLines() {
        return lines;
    }
}
