package ladder.domain;

class Height {

    private final int height;
    private static final int HEIGHT_MIN_BOUND = 0;

    Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height <= HEIGHT_MIN_BOUND) {
            throw new IllegalArgumentException(String.format("높이는 %d보다 커야합니다", HEIGHT_MIN_BOUND));
        }
    }

    int getHeight() {
        return height;
    }

}
