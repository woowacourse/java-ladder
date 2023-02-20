package ladder.domain;

public class Position {
    private final int value;

    public Position(int value) {
        validateNegative(value);
        this.value = value;
    }

    private void validateNegative(int value) {
        if(value < 0) {
            throw new IllegalArgumentException("위치는 음수 값일 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
