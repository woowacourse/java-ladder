package model;

public abstract class Count {
    private static final int MINIMUM_NUMBER = 0;

    private final int count;

    protected Count(final int count) {
        validateCount(count);
        validateNegativeCount(count);
        this.count = count;
    }

    protected abstract void validateCount(final int count);

    private void validateNegativeCount(final int count) {
        if (count < MINIMUM_NUMBER) {
            throw new IllegalArgumentException("카운트는 음수일 수 없습니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
