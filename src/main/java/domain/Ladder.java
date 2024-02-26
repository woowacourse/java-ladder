package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<RowLine> lines;

    public Ladder(List<RowLine> lines) {
        validateLinesSizeEqual(lines);
        this.lines = lines;
    }

    public int drive(int index) {
        return IntStream.range(0, getRowLineCount())
                .reduce(index, (currentColumn, i) -> lines.get(i).navigateNextColumn(currentColumn));
    }

    public RowLine getLineByIndex(int index) {
        return lines.get(index);
    }

    public int getRowLineCount() {
        return lines.size();
    }

    public int getColumnCount() {
        return lines.get(0).getConnectionCount() + 1;
    }

    private void validateLinesSizeEqual(List<RowLine> lines) {
        if (!isAllLineSameSize(lines)) {
            throw new IllegalArgumentException("[ERROR] 사다리를 구성하는 줄들의 길이가 같지 않습니다");
        }
    }

    private boolean isAllLineSameSize(List<RowLine> lines) {
        return lines.stream()
                .allMatch(rowLine -> rowLine.getConnectionCount() == lines.get(0).getConnectionCount());
    }
}
