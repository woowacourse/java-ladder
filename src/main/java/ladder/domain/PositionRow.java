package ladder.domain;

public class PositionRow {
    private final int position;
    private static final PositionRowCache cache = PositionRowCache.of(5);

    public PositionRow(int position) {
        validatePosition(position);
        this.position = position;
    }

    public PositionRow left() {
        return getFromCacheOrCreate(position - 1);
    }

    public PositionRow right() {
        return getFromCacheOrCreate(position + 1);
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException();
        }
    }

    private PositionRow getFromCacheOrCreate(int position) {
        try {
            return cache.get(position);
        } catch (IllegalArgumentException e) {
            return new PositionRow(position);
        }
    }

    public int getPosition() {
        return position;
    }
}
