package ladder.domain;

public class PositionRow {
    private final int maxPosition;
    private int position;

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

    public void moveLeft() {
        validatePositionLimit(position - 1, maxPosition);
        position--;
    }

    public void moveRight() {
        validatePositionLimit(position + 1, maxPosition);
        position++;
    }

    public int getPosition() {
        return position;
    }
}
