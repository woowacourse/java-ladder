package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Position {
    private static final int POSITION_VALUE_LOWER_BOUND = 0;
    private static final int POSITION_VALUE_UPPER_BOUND = 20;
    private static final int MOVE_COUNT = 1;
    private static final String INVALID_VALUE_MESSAGE =
            "위치값은 " + POSITION_VALUE_LOWER_BOUND + "이상, " + POSITION_VALUE_UPPER_BOUND + "미만이어야 합니다.";
    private static final Position EMPTY = new Position(Integer.MIN_VALUE);
    private static final Map<Integer, Position> CACHE = new HashMap<>();

    static {
        for (int i = POSITION_VALUE_LOWER_BOUND; i < POSITION_VALUE_UPPER_BOUND; i++) {
            CACHE.put(i, new Position(i));
        }
    }

    private final int value;

    private Position(final int value) {
        this.value = value;
    }

    public static Position valueOf(final int value) {
        validate(value);
        return CACHE.get(value);
    }

    private static void validate(final int value) {
        if (isInvalidPosition(value)) {
            throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
        }
    }

    private static boolean isInvalidPosition(final int value) {
        return value < POSITION_VALUE_LOWER_BOUND || POSITION_VALUE_UPPER_BOUND <= value;
    }

    public static List<Position> range(final int endExclusive) {
        return IntStream.range(POSITION_VALUE_LOWER_BOUND, endExclusive)
                .mapToObj(Position::valueOf)
                .collect(Collectors.toList());
    }

    public Position getPrevious() {
        return CACHE.getOrDefault(this.value - MOVE_COUNT, EMPTY);
    }

    public Position getNext() {
        return CACHE.getOrDefault(this.value + MOVE_COUNT, EMPTY);
    }

    public int getValue() {
        return value;
    }
}
