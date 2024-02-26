package ladder.domain;

public class Height {

    private final int value;

    public Height(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("사다리 높이는 1이상 입니다.");
        }
    }

    public boolean isSame(int value) {
        return this.value == value;
    }
}
