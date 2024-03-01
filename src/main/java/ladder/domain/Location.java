package ladder.domain;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.stream.IntStream;

public record Location(int value) {
    private static final int MIN_LOCATION = 0;
    private static final int MIN_CACHE = 0;
    private static final int MAX_CACHE = 20;
    private static final Map<Integer, Location> CACHE = IntStream.range(MIN_CACHE, MAX_CACHE)
            .boxed()
            .collect(toMap(identity(), Location::new));

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
        int newValue = value + direction.getMovement();
        if (MIN_CACHE <= newValue && newValue <= MAX_CACHE) {
            return CACHE.get(newValue);
        }
        return new Location(newValue);
    }
}
