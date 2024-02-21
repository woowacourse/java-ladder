package domain;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 2;

    private final String name;

    public Name(String value) {
        validateNameLength(value);
        this.name = value;
    }

    private void validateNameLength(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (value.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getValue() {
        return name;
    }
}
