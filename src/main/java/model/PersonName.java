package model;

public record PersonName(String name) {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public PersonName {
        validateNameLength(name);
    }

    private void validateNameLength(final String name) {
        final int length = name.length();
        if (length < MIN_NAME_LENGTH || length > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최소 1글자 최대 5글자여야 합니다.");
        }
    }
}
