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

    public int playByPosition(final int horizontalPosition) {
        final Position position = new Position(horizontalPosition, 0);

        while (position.getVerticalLocation() < getHeight()) {
            moveHorizontally(position);
            position.moveDown();
        }

        return position.getHorizontalLocation();
    }

    private void moveHorizontally(final Position position) {
        final int beforeHorizontalLocation = position.getHorizontalLocation() - 1;
        final boolean beforeConnectivity = inRange(beforeHorizontalLocation) &&
                hasBridge(beforeHorizontalLocation, position.getVerticalLocation());
        final boolean currentConnectivity = inRange(position.getHorizontalLocation()) &&
                hasBridge(position.getHorizontalLocation(), position.getVerticalLocation());

        position.moveLeft(beforeConnectivity);
        position.moveRight(currentConnectivity);
    }

    private boolean hasBridge(final int horizontalLocation, final int verticalLocation) {
        final Line currentLine = ladder.get(verticalLocation);
        return currentLine.checkConnectivity(horizontalLocation);
    }

    private boolean inRange(final int horizontalPosition) {
        return horizontalPosition >= 0 && horizontalPosition < getWidth();
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
