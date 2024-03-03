package domain;

import java.util.List;
import java.util.stream.Stream;

public class Ladder {

    private final Height height;
    private final List<Line> lines;

    public Ladder(int floor, int participantsCount, StepGenerator stepGenerator) {
        height = new Height(floor);
        int stepPointCount = participantsCount - 1;
        lines = Stream.generate(() -> new Line(stepPointCount, stepGenerator))
                .limit(floor)
                .toList();
    }

    public void findLastLocation(Player player) {
        for (Line line : lines) {
            line.findNextLocation(player);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
