package model;

public abstract class Count {
    private static final int MINIMUM_NUMBER = 0;

    private final int value;

    protected Count(final int rawCount) {
        validateCount(rawCount);
        validateNegativeCount(rawCount);
        this.value = rawCount;
    }

    protected abstract void validateCount(final int rawCount);

    private void validateNegativeCount(final int rawCount) {
        if (rawCount < MINIMUM_NUMBER) {
            throw new IllegalArgumentException("카운트는 음수일 수 없습니다.");
        }
    }

    public int getCount() {
        return value;
    }
}
