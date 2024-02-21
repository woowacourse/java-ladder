package domain;

class Width {
    private final int length;

    Width(int length) {
        validate(length);
        this.length = length;
    }

    private void validate(int width) {
        if (width < 2 || width > 10) {
            throw new RuntimeException("폭은 2이상 10 이하여야 합니다.");
        }
    }

    int getLength() {
        return length;
    }
}
