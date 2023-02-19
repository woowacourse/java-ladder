package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

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

    public int getHeight() {
        return lines.size();
    }

    public List<String> asString() {
        return lines.stream()
                .map(Line::asString)
                .collect(Collectors.toList());
    }
}
