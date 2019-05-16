package ladder.domain;

import java.util.List;

public final class Ladder {
    private static final int MIN_HEIGHT = 1;
    private static final int MIN_PLAYER_COUNT = 2;

    private final List<Line> lines;

    public Ladder(int height, int countOfPlayers) {
        this(height, countOfPlayers, new LineRandomGenerator(countOfPlayers, height));
    }

    public Ladder(int height, int countOfPlayers, LineGenerator lineGenerator) {
        validate(height, countOfPlayers);
        this.lines = lineGenerator.generate();
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

    public List<Line> getLines() {
        return lines;
    }
}