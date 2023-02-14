package domain;

public class Name {

    private static final String LENGTH_ERROR_MESSAGE = "이름은 1 ~ 5 글자여야 합니다.";
    private static final int LENGTH_LOWER_BOUND_INCLUSIVE = 1;
    private static final int LENGTH_UPPER_BOUND_INCLUSIVE = 5;

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    public void validateName(String name) {
        if (isOutOfRange(name)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private boolean isOutOfRange(String name) {
        return !(LENGTH_LOWER_BOUND_INCLUSIVE <= name.length()
                && name.length() <= LENGTH_UPPER_BOUND_INCLUSIVE);
    }
}
