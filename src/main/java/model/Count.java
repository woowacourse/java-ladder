package model;

public abstract class Count {
    private final int count;

    Count(final int count) {
        validateCount(count);
        validateNegativeCount(count);
        this.count = count;
    }

    protected abstract void validateCount(final int count);

    private void validateNegativeCount(final int count) {
        if (count < 0) {
            throw new IllegalArgumentException("카운트는 음수일 수 없습니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
