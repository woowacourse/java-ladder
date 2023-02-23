package laddergame.domain;

public class Height {
    private static final int FINISH_NUMBER = 0;

    private final int height;

    public Height(String height) {
        validate(height);
        this.height = Integer.parseInt(height);
    }

    public boolean isPossibleCount() {
        return this.height > FINISH_NUMBER;
    }

    public int getHeight() {
        return height;
    }

    private void validate(String height) {
        try {
            int heightNumber = Integer.parseInt(height);
            if (heightNumber <= 0) {
                throw new IllegalArgumentException("양의 정수만 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("양의 정수만 입력해주세요.");
        }
    }
}
