package domain;

public class Person {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 1글자 이상 5글자 이하여야 합니다";

    private final String name;

    public Person(final String name) {
        validateMinNameLength(name);
        validateMaxNameLength(name);
        this.name = name;
    }

    private void validateMinNameLength(final String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void validateMaxNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
