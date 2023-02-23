package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int MAX_HEIGHT_RATIO = 2;

    private final List<Line> lines;

    public Ladder(List<Line> lines, Players players) {
        validateLadder(lines, players);
        this.lines = lines;
    }

    private void validateLadder(List<Line> lines, Players players) {
        validateLinesWidth(lines, players.getPlayersCount());
        validatePlayersCount(lines.size(), players.getPlayersCount());
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

    private void validatePlayersCount(int height, int playersCount) {
        if (isProperRange(height, playersCount)) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
        }
    }

    private boolean isProperRange(int height, int playersCount) {
        return playersCount * MAX_HEIGHT_RATIO < height || height < playersCount;
    }

    public Line findLineByIndex(int index) {
        if (isProperIndex(index)) {
            throw new IllegalArgumentException("[ERROR] 인덱스 범위를 초과했습니다.");
        }
        return lines.get(index);
    }

    private boolean isProperIndex(int index) {
        return index < 0 || index >= lines.size();
    }

    public int getLadderIndexResult(int index) {
        for (Line line : lines) {
            index = line.nextLadderIndex(index);
        }
        return index;
    }

    public int getHeight() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
