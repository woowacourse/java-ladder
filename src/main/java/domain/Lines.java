package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lines {

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 10;

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        validateLines(lines);
        this.lines = lines;
    }

    private void validateLines(List<Line> lines) {
        if (lines.size() < MIN_RANGE || lines.size() > MAX_RANGE) {
            throw new IllegalArgumentException(
                    String.format("사다리 높이는 %d 이상 %d 이하여야 합니다.", MIN_RANGE, MAX_RANGE));
        }
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).size();
    }

    public Column move(Column column) {
        for (Line line : lines) {
            line.move(column);
        }
        return column;
    }

    public List<Line> getLines() {
        return lines.stream()
                .map(Line::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
