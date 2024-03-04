package ladder.domain;

public class Height {

    private final int value;

    public Height(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        validateMinValue(value);
    }

    private void validateMinValue(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("높이가 0 이하입니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
