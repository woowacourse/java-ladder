package utils.validator;

public class LadderSizeValidator {

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 100;

    public static void validate(String size) {
        validateIntRange(size);
        validateRange(Integer.parseInt(size));
    }

    private static void validateIntRange(String size) {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Message.EXCEPTION_INT_RANGE.message);
        }
    }

    private static void validateRange(int size) {
        if (size < MIN_RANGE || size > MAX_RANGE) {
            throw new IllegalArgumentException(Message.EXCEPTION_RANGE.message);
        }
    }

    private enum Message {
        EXCEPTION_INT_RANGE("자연수만 입력해 주세요."),
        EXCEPTION_RANGE("%d 이상 %d 이하의 자연수만 입력해 주세요.", MIN_RANGE, MAX_RANGE);

        public static final String BASE_MESSAGE = "[ERROR] %s";
        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
        }
    }
}
