package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines, int playersCount) {
        validateLinesWidth(lines, playersCount);
        this.lines = lines;
    }

    private void validateLinesWidth(List<Line> lines, int playerCount) {
        for (Line line : lines) {
            validateLineWidth(line, playerCount);
        }
    }

    private void validateLineWidth(Line line, int playerCount) {
        if (line.getWidth() != playerCount) {
            throw new IllegalArgumentException("[ERROR] 사다리의 너비는 사람의 수와 같아야 합니다.");
        }
    }

    public int getLadderIndexResult(int index) {
        for (Line line : lines) {
            index = line.nextLineIndex(index);
        }
        return index;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
