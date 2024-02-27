package ladder.domain;

public class PositionRow {
    private final int maxPosition;
    private final int position;
    private static final PositionRowCache cache = PositionRowCache.of(5);

    public PositionRow(int start, int maxPosition) {
        validatePosition(start, maxPosition);
        validatePositionLimit(start, maxPosition);
        this.maxPosition = maxPosition;
        this.position = start;
    }

    public PositionRow left() {
        validatePositionLimit(position - 1, maxPosition);
        return getFromCacheOrCreate(position - 1, maxPosition);

    }

    public PositionRow right() {
        validatePositionLimit(position + 1, maxPosition);
        return getFromCacheOrCreate(position + 1, maxPosition);
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

    private PositionRow getFromCacheOrCreate(int position, int maxPosition) {
        try {
            return cache.get(position, maxPosition);
        } catch (IllegalArgumentException e) {
            return new PositionRow(position, maxPosition);
        }
    }

    public int getPosition() {
        return position;
    }
}
