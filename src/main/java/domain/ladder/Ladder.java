package domain.ladder;

import domain.value.Direction;
import domain.value.Height;
import domain.value.Position;
import domain.value.Width;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Ladder {

    private static final int UNIQUE_COUNT = 1;
    private static final int FIRST_LINE_INDEX = 0;

    private final List<Line> lines;

    Ladder(final List<Line> lines) {
        validate(lines);
        this.lines = new ArrayList<>(lines);
    }

    private void validate(final List<Line> lines) {
        validateLineSizeEmpty(lines);
        validateLinesSameSize(lines);
    }

    private void validateLineSizeEmpty(final List<Line> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다");
        }
    }

    private void validateLinesSameSize(final List<Line> lines) {
        if (lineSizeNotUnique(lines)) {
            throw new IllegalArgumentException("사다리의 가로 줄은 모두 동일한 길이를 가져야 합니다.");
        }
    }

    private boolean lineSizeNotUnique(final List<Line> lines) {
        return linesSizeCount(lines) != UNIQUE_COUNT;
    }

    private long linesSizeCount(final List<Line> lines) {
        return lines.stream()
                .map(Line::size)
                .distinct()
                .count();
    }

    public Height getHeight() {
        return Height.of(lines.size());
    }

    public Width getWidth() {
        return Width.of(lines.get(FIRST_LINE_INDEX).size());
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    /**
     * 주어진 위치에서부터 사다리를 타고 내려갔을때의 위치를 반환한다.
     * <p>
     * 예시:
     * 0     1     2     3
     * |-----|     |-----|
     * |     |-----|     |
     * |-----|     |     |
     * |     |-----|     |
     * |-----|     |-----|
     * 0     1     2     3
     * <p>
     * 0 에서 내려가는 경우 -> 0
     * 1 에서 내려가는 경우 -> 3
     * 2 에서 내려가는 경우 -> 2
     * 3 에서 내려가는 경우 -> 1
     */
    public Position goDown(Position position) {
        Deque<Line> linesForGoDown = new ArrayDeque<>(lines);
        while (!linesForGoDown.isEmpty()) {
            Line line = linesForGoDown.removeFirst();
            Direction direction = line.directionOfScaffoldExist(position);
            position = position.move(direction);
        }
        return position;
    }
}
