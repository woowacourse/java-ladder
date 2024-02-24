package domain;

import java.util.List;

public class Ladder {
    private static final int MAX_HEIGHT = 100;
    private final List<Line> ladder;

    public Ladder(final List<Line> ladder) {
        validateMaxHeight(ladder.size());
        validateLadderShape(ladder);
        this.ladder = ladder;
    }

    private void validateLadderShape(List<Line> ladder) {
        final int width = ladder.get(0).getWidth();
        if (ladder.stream().anyMatch(line -> line.getWidth() != width)) {
            throw new IllegalArgumentException("사다리의 가로 길이는 일정해야 합니다.");
        }
    }

    private void validateMaxHeight(int height) {
        if (height > MAX_HEIGHT) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사다리 높이는 최대 %d입니다.", height, MAX_HEIGHT));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public int getHeight() {
        return ladder.size();
    }

    public int getWidth() {
        Line firstLine = ladder.get(0);
        return firstLine.getWidth();
    }

    public int play(int position) {
        int currentHeight = 0;
        int ladderHeight = getHeight();
        while (currentHeight < ladderHeight) {
            position += horizontalMovement(position, currentHeight);
            currentHeight++;
        }
        return position;
    }

    private int horizontalMovement(int position, int currentHeight) {
        if (position < getWidth() && ladder.get(currentHeight).getBridges().get(position).getBridge()) {
            return 1;
        }
        if (position - 1 >= 0 && ladder.get(currentHeight).getBridges().get(position - 1).getBridge()) {
            return -1;
        }
        return 0;
    }
}
