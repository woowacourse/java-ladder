package ladder.domain;

public class Direction {
    private final boolean left;
    private final boolean current;

    public Direction(boolean left, boolean current) {
        validateNotConsecutiveTrue(left, current);
        this.left = left;
        this.current = current;
    }

    private void validateNotConsecutiveTrue(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("사다리 선이 가로로 연속적일 수 없습니다.");
        }
    }
}
