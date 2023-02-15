package utils.validator;

public class LadderSizeValidator {
    public static void validate(String size) {
        validateIntRange(size);
        validateRange(Integer.parseInt(size));
    }

    private static void validateIntRange(String size) {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(int size) {
        if (size < 1 || size > 100) {
            throw new IllegalArgumentException();
        }
    }
}
