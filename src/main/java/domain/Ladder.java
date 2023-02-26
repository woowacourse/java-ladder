package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 10;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateHeight(lines);
        this.lines = lines;
    }

    private void validateHeight(List<Line> lines) {
        if (lines.size() < MIN_RANGE || lines.size() > MAX_RANGE) {
            throw new IllegalArgumentException(
                    String.format("사다리 높이는 %d 이상 %d 이하여야 합니다.", MIN_RANGE, MAX_RANGE));
        }
    }

    public Column calculateResult(Column column) {
        for (Line line : lines) {
            line.move(column);
        }
        return column;
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).size();
    }

    public List<Line> getLines() {
        return lines.stream()
                .map(Line::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
