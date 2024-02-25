package domain.player;

public class Position {

    private final int positionValue;
    public Position(int positionValue) {
        validate(positionValue);
        this.positionValue = positionValue;
    }

    private void validate(int positionValue) {
        if (positionValue < 0) {
            throw new IllegalArgumentException("음의 위치를 가질 수 없습니다.");
        }
    }
}
