package ladder.domain.player;

import java.util.HashMap;
import java.util.Map;

class Position {

    private static final int MIN_POSITION = 0;
    private static final Map<Integer, Position> CACHE = new HashMap<>();

    private final int index;

    private Position(int index) {
        this.index = index;
    }

    static Position valueOf(int index) {
        validateMinimumIndex(index);
        Position exist = CACHE.get(index);
        if (exist != null) {
            return exist;
        }
        return CACHE.computeIfAbsent(index, Position::new);
    }

    private static void validateMinimumIndex(int index) {
        if (index < MIN_POSITION) {
            throw new IllegalArgumentException("index 는 " + MIN_POSITION + " 이상이어야 합니다.");
        }
    }
}
