package domain;

import java.util.List;

public class Ladder {
    private static final int MAX_HEIGHT = 100;

    private final List<Line> ladder;

    public Ladder(final List<Line> ladder) {
        validate(ladder);
        this.ladder = ladder;
    }

    private void validate(final List<Line> ladder) {
        validateEmptiness(ladder);
        validateMaxHeight(ladder);
        validateLadderShape(ladder);
    }

    private void validateEmptiness(final List<Line> ladder) {
        if (ladder.isEmpty()) {
            throw new IllegalArgumentException("사다리 가로 라인 길이는 1 이상이어야 합니다");
        }
    }

    private void validateLadderShape(final List<Line> ladder) {
        final int firstLineWidth = ladder.get(0).getWidth();
        if (ladder.stream().anyMatch(line -> line.getWidth() != firstLineWidth)) {
            throw new IllegalArgumentException("사다리의 가로 길이는 일정해야 합니다.");
        }
    }

    private void validateMaxHeight(final List<Line> ladder) {
        final int height = ladder.size();
        if (height > MAX_HEIGHT) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사다리 높이는 최대 %d입니다.", height, MAX_HEIGHT));
        }
    }

    public int playByPosition(int position) {
        int currentHeight = 0;
        final int ladderHeight = getHeight();
        while (currentHeight < ladderHeight) {
            position += horizontalMovement(position, currentHeight);
            currentHeight++;
        }
        return position;
    }

    private int horizontalMovement(final int position, final int currentHeight) {
        final int beforePosition = position - 1;
        if (inRange(position) && hasBridge(position, currentHeight)) {
            return 1;
        }
        if (inRange(beforePosition) && hasBridge(beforePosition, currentHeight)) {
            return -1;
        }
        return 0;
    }

    private boolean hasBridge(final int position, final int currentHeight) {
        final Line currentLine = ladder.get(currentHeight);
        return currentLine.checkConnectivity(position);
    }

    private boolean inRange(final int position) {
        return position >= 0 && position < getWidth();
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public int getHeight() {
        return ladder.size();
    }

    public int getWidth() {
        final Line firstLine = ladder.get(0);
        return firstLine.getWidth();
    }
}
