package ladder.domain;

public class PositionRow {
    private final int maxPosition;
    private final int position;

    public PositionRow(int start, int maxPosition) {
        validatePosition(start, maxPosition);
        validatePositionLimit(start, maxPosition);
        this.maxPosition = maxPosition;
        this.position = start;
    }

    private void validatePosition(int start, int maxPosition) {
        if (start < 0 || maxPosition < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePositionLimit(int position, int maxPosition) {
        if (position < 0 || position > maxPosition) {
            throw new IllegalStateException();
        }
    }

    public PositionRow left() {
        validatePositionLimit(position - 1, maxPosition);
        return new PositionRow(position - 1, maxPosition);
    }

    public PositionRow right() {
        validatePositionLimit(position + 1, maxPosition);
        return new PositionRow(position + 1, maxPosition);
    }

    public int getPosition() {
        return position;
    }
}
