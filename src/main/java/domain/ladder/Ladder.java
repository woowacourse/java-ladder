package domain.ladder;

import java.util.List;
import java.util.stream.Stream;
import utils.StepGenerator;

public class Ladder {

    private final List<Line> lines;
    private final Height height;

    public Ladder(int floor, int participantsCount, StepGenerator stepGenerator) {
        int stepPointCount = participantsCount - 1;
        height = new Height(floor);
        lines = Stream.generate(() -> new Line(stepPointCount, stepGenerator))
                .limit(floor)
                .toList();
    }

    public boolean isFinish(int floor) {
        return height.isEqualTo(floor);
    }

    public boolean canMoveLeft(int floor, int step) {
        if (isFinish(floor)) {
            return false;
        }
        Line line = lines.get(floor);
        return line.isExistLeftStep(step);
    }

    public boolean canMoveRight(int floor, int step) {
        if ((isFinish(floor))) {
            return false;
        }
        Line line = lines.get(floor);
        return line.isExistRightStep(step);
    }

    public List<Line> getLines() {
        return lines;
    }
}
