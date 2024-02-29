package ladder.domain;

public record Location(int value) {
    private static final int MIN_LOCATION = 0;

    public Location {
        if (value < MIN_LOCATION) {
            throw new IllegalStateException(
                    "위치 입력 코드에 문제가 있습니다: %d".formatted(value)
                            + "\n사용자 입력 후 발생한 경우: Players의 생성자에서 Player를 생성할 때 문제가 있을 확률이 높음."
                            + "\n모든 결과 입력 후 발생한 경우: Ladder의 findResultLocation에 문제가 있을 확률이 높음."
            );
        }
    }

    public Location move(Direction direction) {
        return new Location(value + direction.getMovement());
    }
}
