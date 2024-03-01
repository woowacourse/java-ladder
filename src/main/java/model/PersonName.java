package model;

public class PersonName extends Name {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    protected PersonName(final String name) {
        super(name);
    }

    @Override
    protected void validateName(final String name) {
        validateNameLength(name);
    }

    private void validateNameLength(final String name) {
        final int length = name.length();
        if (length < MIN_NAME_LENGTH || length > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최소 1글자 최대 5글자여야 합니다.");
        }
    }
}
