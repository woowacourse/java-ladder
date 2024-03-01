package model;

public abstract class Count {
    private final int count;

    protected Count(final int count) {
        validateCount(count);
        validateNegativeCount(count);
        this.count = count;
    }

    protected abstract void validateCount(final int count);

    private void validateNegativeCount(final int count) {
        if (count < 0) {
            throw new IllegalArgumentException("갯수 음수일 수 없습니다.");
        }
    }
}
