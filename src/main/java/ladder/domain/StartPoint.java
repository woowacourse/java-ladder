package ladder.domain;

public class StartPoint {
    private final int position;

    public StartPoint(int position) {
        validateNegativePosition(position);
        this.position = position;
    }

    private void validateNegativePosition(int position) {
        if(position < 0) {
            throw new IllegalStateException("플레이어의 시작 위치는 0 이상이어야 합니다.");
        }
    }
}
