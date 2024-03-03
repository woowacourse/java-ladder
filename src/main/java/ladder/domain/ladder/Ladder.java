package ladder.domain.ladder;

import java.util.List;
import ladder.domain.line.Line;

public class Ladder {

    private static final int MAX_LINE_SIZE = 50;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateLineSize(lines);
        validateConsistentLineSize(lines);
        this.lines = lines;
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).getSize();
    }

    private void validateLineSize(List<Line> linesToAdd) {
        if (linesToAdd.isEmpty() || linesToAdd.size() > MAX_LINE_SIZE) {
            throw new IllegalArgumentException("[ERROR] 라인은 1~50개 까지만 등록 가능합니다.");
        }
    }

    private void validateConsistentLineSize(List<Line> linesToAdd) {
        int expectedLineCount = linesToAdd.get(0).getSize();

        if (!linesToAdd.stream().allMatch(line -> line.getSize() == expectedLineCount)) {
            throw new IllegalArgumentException("[ERROR] 사다리의 모든 라인의 너비는 동일해야 합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
