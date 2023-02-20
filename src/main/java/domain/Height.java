package domain;

public class Height {
    private static final int FINISH_NUMBER = 0;
    public static final String NOT_POSITIVE_ERROR_MESSAGE = "양의 정수만 입력해주세요.";

    private int height;

    public Height(String height) {
        validate(height);
        this.height = Integer.parseInt(height);
    }

    public boolean isPossibleCount() {
        return this.height > FINISH_NUMBER;
    }

    public void minusHeight() {
        this.height--;
    }

    private void validate(String height) {
        if (Integer.parseInt(height) <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }
}
