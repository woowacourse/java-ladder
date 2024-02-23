package domain;

class Width {
    static final int MIN = 2;
    static final int MAX = 10;

    private final int length;

    Width(int length) {
        validate(length);
        this.length = length;
    }

    int getLength() {
        return length;
    }

    private void validate(int width) {
        if (width < MIN || width > MAX) {
            throw new LadderGameException(ExceptionType.WIDTH_RANGE);
        }
    }


}
