package model.people;

import model.Name;

public class PersonName extends Name {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    protected PersonName(final String rawName) {
        super(rawName);
    }

    @Override
    protected void validateName(final String rawName) {
        validateNameLength(rawName);
    }

    private void validateNameLength(final String rawName) {
        final int length = rawName.length();
        if (length < MIN_NAME_LENGTH || length > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최소 1글자 최대 5글자여야 합니다.");
        }
    }
}
