package domain;

import java.util.List;

public class Ladder {

    private final List<RowLine> lines;

    public Ladder(List<RowLine> lines) {
        validateLinesSizeEqual(lines);
        this.lines = lines;
    }

    public int drive(ColumnPosition columnPosition) {
        return lines.stream()
                .reduce(columnPosition, (currentPosition, rowLine) -> rowLine.nextPosition(currentPosition),
                        (a, b) -> b)
                .getColumnPosition();
    }

    public RowLine getLineByIndex(int index) {
        return lines.get(index);
    }

    public int getRowLineCount() {
        return lines.size();
    }

    public int getColumnCount() {
        return lines.get(0).getPointCount();
    }

    private void validateLinesSizeEqual(List<RowLine> lines) {
        if (!isAllLineSameSize(lines)) {
            throw new IllegalArgumentException("[ERROR] 사다리를 구성하는 줄들의 길이가 같지 않습니다");
        }
    }

    private boolean isAllLineSameSize(List<RowLine> lines) {
        int pointCount = lines.get(0).getPointCount();
        return lines.stream()
                .allMatch(rowLine -> rowLine.getPointCount() == pointCount);
    }
}
