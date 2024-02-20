package domain;

public class Height {
    private final int height;

    public Height(final int value) {
        validateHeight(value);
        this.height = value;
    }

    private void validateHeight(int value) {
        if (value < 1) {
            throw new IllegalArgumentException();
        }
    }
}
