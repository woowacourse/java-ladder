package domain;

public class Height {

    private final int value;

    public Height(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int intValue) {
        if (intValue <= 0) {
            throw new IllegalArgumentException("높이는 자연수를 입력해주세요.");
        }
    }

    public int getValue() {
        return value;
    }
}
