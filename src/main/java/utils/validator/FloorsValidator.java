package utils.validator;

public class FloorsValidator {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;

    public static void validateFloorCount(int floorCount) {
        if (floorCount < MIN_RANGE || floorCount > MAX_RANGE) {
            throw new IllegalArgumentException(Message.EXCEPTION_RANGE.message);
        }
    }

    private enum Message {
        EXCEPTION_RANGE("%d 이상 %d 이하의 자연수만 입력해 주세요.", MIN_RANGE, MAX_RANGE);

        public static final String BASE_MESSAGE = "[ERROR] %s";
        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
        }
    }
}
