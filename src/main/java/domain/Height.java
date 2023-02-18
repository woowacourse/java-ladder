package domain;

public class Height {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    public void validate(int height) {
        if (height < MIN_RANGE || height > MAX_RANGE) {
            throw new IllegalArgumentException(Message.EXCEPTION_RANGE.message);
        }
    }

    public int getHeight() {
        return height;
    }

    private enum Message {
        EXCEPTION_RANGE("%d 이상 %d 이하의 자연수만 입력해 주세요.", MIN_RANGE, MAX_RANGE);

        public static final String _FORMAT = "[ERROR] %s";
        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(_FORMAT, String.format(message, replaces));
        }
    }
}
