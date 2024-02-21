package domain;

class Width {
    private final int length;

    Width(int length) {
        validate(length);
        this.length = length;
    }

    private void validate(int width) {
        if (width < 2 || width > 10) {
            throw new LadderGameException(ExceptionType.WIDTH_RANGE);
        }
    }

    int getLength() {
        return length;
    }
}
