package ladder.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 참가자의 위치와 결과의 위치를 나타내는 클래스 1. 0 이상의 정수만 허용 2. 0 이상의 동일한 정수를 입력하면 동일한 객체를 반환
 * <p>
 * 0보다 작은 정수를 입력하면 IllegalArgumentException 발생
 */
public class Position {

    private static final int MIN_POSITION = 0;
    private static final Map<Integer, Position> CACHE = new HashMap<>();

    private final int index;

    private Position(int index) {
        validateMinimumIndex(index);
        this.index = index;
    }

    public static Position valueOf(int index) {
        Position exist = CACHE.get(index);
        if (exist != null) {
            return exist;
        }
        return CACHE.computeIfAbsent(index, Position::new);
    }

    private void validateMinimumIndex(int index) {
        if (index < MIN_POSITION) {
            throw new IllegalArgumentException("index 는 " + MIN_POSITION + " 이상이어야 합니다.");
        }
    }

    Position moveRight() {
        return valueOf(index + 1);
    }

    Position moveLeft() {
        return valueOf(index - 1);
    }

    int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Position{" +
                "index=" + index +
                '}';
    }
}
