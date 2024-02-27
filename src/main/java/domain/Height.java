package domain;

public class Height {

    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("높이는 자연수를 입력해주세요.");
        }
    }

    public int getHeight() {
        return height;
    }
}
