package model.people;

import model.Count;

public class PersonCount extends Count {
    private static final int MIN_PERSON_COUNT = 2;

    public PersonCount(final int rawCount) {
        super(rawCount);
    }

    @Override
    protected void validateCount(final int rawCount) {
        validateMinimumPersonCount(rawCount);
    }

    private void validateMinimumPersonCount(final int rawCount) {
        if (rawCount < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("참여 인원은 최소 2여야 합니다.");
        }
    }

    public boolean isNotEqual(final int value) {
        return super.getCount() != value;
    }
}
