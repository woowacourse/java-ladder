package domain;

public class Name {

    private static final int LENGTH_LOWER_BOUND = 1;
    private static final int LENGTH_UPPER_BOUND = 5;
    private static final String INVALID_LENGTH_MESSAGE = "이름은 1글자에서 5글자 사이이어야 합니다.";

    private final String name;

    public Name(String name) {
        String trimmedName = name.trim();

        validate(trimmedName);
        this.name = trimmedName;
    }

    private static void validate(String name) {
        if (isValidLength(name)) {
            return;
        }

        throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
    }

    private static boolean isValidLength(String name) {
        int length = name.length();

        return length >= LENGTH_LOWER_BOUND && length <= LENGTH_UPPER_BOUND;
    }

    public String getName() {
        return name;
    }
}
