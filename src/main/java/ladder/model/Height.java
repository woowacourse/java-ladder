package ladder.model;

public class Height {
    private static final int MIN_HEIGHT = 2;
    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_INVALID_HEIGHT.getMessage());
        }
    }

    public int getHeight() {
        return height;
    }

    private enum ErrorMessage {
        EXCEPTION_INVALID_HEIGHT("사다리 높이는 2 이상이어야 합니다.");
        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }

}
