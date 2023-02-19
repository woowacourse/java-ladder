package ladder.domain;

public class LadderHeight {

    private final int value;

    public LadderHeight(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }

    public int get() {
        return value;
    }
}
