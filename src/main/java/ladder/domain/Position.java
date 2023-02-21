package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Position {

    private static final int POSITION_VALUE_LOWER_BOUND = 1;
    private static final int POSITION_VALUE_UPPER_BOUND = 20;
    private static final String INVALID_VALUE_MESSAGE =
            "위치값은 " + POSITION_VALUE_LOWER_BOUND + "이상, " + POSITION_VALUE_UPPER_BOUND + "이하여야 합니다.";
    private static final Map<Integer, Position> CACHE = new HashMap<>();

    static {
        for (int i = POSITION_VALUE_LOWER_BOUND; i <= POSITION_VALUE_UPPER_BOUND; i++) {
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
        return value < POSITION_VALUE_LOWER_BOUND || POSITION_VALUE_UPPER_BOUND < value;
    }

    public int getValue() {
        return value;
    }
}
