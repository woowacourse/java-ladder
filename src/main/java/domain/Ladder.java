package domain;

import java.util.List;

public class Ladder {

    private final List<RowLine> lines;

    public Ladder(List<RowLine> lines) {
        validateLinesSizeEqual(lines);
        this.lines = lines;
    }

    public RowLine getLineByIndex(int index) {
        return lines.get(index);
    }

    public int getRowLineCount() {
        return lines.size();
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
