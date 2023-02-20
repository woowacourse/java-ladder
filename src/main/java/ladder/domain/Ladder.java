package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int MAX_HEIGHT_RATIO = 2;

    private final List<Line> lines;

    public Ladder(List<Line> lines, int playerCount) {
        validatePlayersCount(lines.size(), playerCount);
        this.lines = lines;
    }

    private void validatePlayersCount(int height, int playersCount) {
        if (isProperRange(height, playersCount)) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
        }
    }

    private static boolean isProperRange(int height, int playersCount) {
        return playersCount * MAX_HEIGHT_RATIO < height || height < playersCount;
    }

    public boolean isLastHeight(int height) {
        return lines.size() == height + 1;
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

    public int getHeight() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
