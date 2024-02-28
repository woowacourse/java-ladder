package ladder.domain;

public record Location(int value) {
    private static final int MIN_LOCATION = 0;

    public Location {
        if (value < MIN_LOCATION) {
            throw new IllegalStateException(
                    "위치 입력 코드에 문제가 있습니다: %d".formatted(value)
            );
        }
    }

    public Location move(Direction direction) {
        return new Location(value + direction.getMovement());
    }
}
