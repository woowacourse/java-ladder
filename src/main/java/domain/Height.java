package domain;

public class Height {
    private final int intValue;

    public Height(int intValue) {
        validate(intValue);
        this.intValue = intValue;
    }

    private void validate(int intValue) {
        if (intValue <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getIntValue() {
        return intValue;
    }
}
