package ladder.domain;

class Height {

    private Height() {
    }

    static void validateHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("높이는 0보다 커야합니다");
        }
    }
}
