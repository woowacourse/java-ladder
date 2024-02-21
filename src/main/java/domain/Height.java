package domain;

class Height {
    private final int length;

    Height(int length) {
        validate(length);
        this.length = length;
    }

    private void validate(int length) {
        if (length < 5 || length > 10) {
            throw new RuntimeException("높이는 5이상 10 이하여야 합니다.");
        }
    }

    int getLength() {
        return length;
    }
}
