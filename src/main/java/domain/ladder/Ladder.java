package domain.ladder;

import java.util.List;
import java.util.stream.Stream;
import utils.StepGenerator;

public class Ladder {

    public static final int MIN_OF_HEIGHT = 0;
    public static final Height ZERO = new Height(MIN_OF_HEIGHT);

    private final List<Line> lines;
    private final Height height;

    public Ladder(Height height, int participantsCount, StepGenerator stepGenerator) {
        int stepPointCount = participantsCount - 1;
        validateHeight(height);
        this.height = height;
        this.lines = Stream.generate(() -> new Line(stepPointCount, stepGenerator))
                .limit(height.getHeight())
                .toList();
    }

    private static void validateHeight(Height height) {
        if (ZERO.equals(height)) {
            throw new IllegalArgumentException("[ERROR] 높이가 0인 사다리는 불가능합니다.");

        }
    }

    public boolean isNotFinish(Height height) {
        return !isFinish(height);
    }

    public boolean isFinish(Height height) {
        return this.height.equals(height);
    }

    public boolean canMoveLeft(Height height, int step) {
        if (isFinish(height)) {
            return false;
        }
        Line line = lines.get(height.getHeight());
        return line.isExistLeftStep(step);
    }

    public boolean canMoveRight(Height height, int step) {
        if (isFinish(height)) {
            return false;
        }
        Line line = lines.get(height.getHeight());
        return line.isExistRightStep(step);
    }

    public List<Line> getLines() {
        return lines;
    }
}
