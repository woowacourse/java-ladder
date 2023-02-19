package ladder.domain;

public class LineWidth {

    private final int value;

    public LineWidth(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("사다리 폭은 1 이상이어야 합니다.");
        }
    }

    public int get() {
        return value;
    }
}
