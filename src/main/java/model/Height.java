package model;

public class Height {

    private static final int UPPER_BOUND = 12;

    private final int value;

    public Height(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value <= 0 || value > UPPER_BOUND) {
            throw new IllegalArgumentException();
        }
    }
}
