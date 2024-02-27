package ladder.domain;

public class Height {

    private final int value;

    public Height(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("1 이상의 정수가 아닙니다.");
        }
    }

    public boolean isSame(int value) {
        return this.value == value;
    }
}
