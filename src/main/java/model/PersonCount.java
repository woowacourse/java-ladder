package model;

public class PersonCount extends Count {
    private static final int MIN_PERSON_COUNT = 2;

    PersonCount(final int count) {
        super(count);
    }

    @Override
    protected void validateCount(final int count) {
        validateMinimumPersonCount(count);
    }

    private void validateMinimumPersonCount(final int count) {
        if (count < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("참여 인원은 최소 2여야 합니다.");
        }
    }

    public boolean isNotEqual(final int itemsCount) {
        return super.getCount() != itemsCount;
    }
}
