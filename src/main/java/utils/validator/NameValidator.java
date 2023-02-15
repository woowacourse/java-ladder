package utils.validator;

public class NameValidator {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;

    public static void validate(String name) {
        validateBlank(name);
        validateLength(name);
    }

    private static void validateLength(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
