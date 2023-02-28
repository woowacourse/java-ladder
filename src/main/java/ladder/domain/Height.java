package ladder.domain;

class Height {

    private static final int HEIGHT_MIN_BOUND = 0;

    Height(int value) {
        validateHeight(value);
    }

    private void validateHeight(int height) {
        if (height <= HEIGHT_MIN_BOUND) {
            throw new IllegalArgumentException(String.format("높이는 %d보다 커야합니다", HEIGHT_MIN_BOUND));
        }
    }
}
