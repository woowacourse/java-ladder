package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public final class Ladder {
    private static final int MIN_HEIGHT = 1;
    private static final int MIN_PLAYER_COUNT = 2;
    private final List<Line> lines;

    public Ladder(int height, int countOfPlayers) {
        validate(height, countOfPlayers);
        this.lines = generateLines(height, countOfPlayers);
    }

    private void validate(int height, int countOfPlayers) {
        validateHeight(height);
        validateCount(countOfPlayers);
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 1이상 이어야 합니다.");
        }
    }

    private void validateCount(int countOfPlayers) {
        if (countOfPlayers < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("사람수는 2명 이상 이어야 합니다.");
        }
    }

    private List<Line> generateLines(int height, int countOfPlayers) {
        List<Line> generatedLines = new ArrayList<>();
        SubLineGenerator subLineGenerator = new SubLineRandomGenerator(countOfPlayers);
        for (int i = 0; i < height; i++) {
            generatedLines.add(new Line(subLineGenerator.generate()));
        }
        return generatedLines;
    }
}
