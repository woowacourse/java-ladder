package domain;

public class Name {

    private static final int LENGTH_LOWER_BOUND = 1;
    private static final int LENGTH_UPPER_BOUND = 5;
    private static final String INVALID_LENGTH_MESSAGE = "이름은 1글자에서 5글자 사이이어야 합니다.";
    private static final String ALL = "all";

    private final String name;

    public Name(final String name) {
        String trimmedName = name.trim();

        validate(trimmedName);
        this.name = trimmedName;
    }

    private void validate(final String name) {
        validateLength(name);
    }

    private void validateLength(final String name) {
        int length = name.length();

        if (length < LENGTH_LOWER_BOUND || length > LENGTH_UPPER_BOUND) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
    }

    public boolean equals(final Name name) {
        return this.name.equals(name.getName());
    }

    public boolean isNotAll() {
        return !name.equals(ALL);
    }

    public String getName() {
        return name;
    }
}
