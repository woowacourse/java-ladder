package ladder.domain;

import java.util.Objects;
import java.util.Random;

/**
 * @author heebg
 * @version 1.0 2019-05-18
 */
public class Position {
    private static final String EX_POSITION_ROW_TRUE_DUPLE = "사다리 가로 라인은 연속으로 생길 수 없습니다.";
    private static final boolean POSITION_EMPTY_VALUE = false;

    private final boolean hasLeft;
    private final boolean current;

    private Position(boolean hasLeft, boolean current) {
        ThrowException.checkArgument(hasLeft && current , EX_POSITION_ROW_TRUE_DUPLE);
        this.hasLeft = hasLeft;
        this.current = current;
    }

    /**
     * 맨 처음 생성
     *
     * @param current
     * @return Position
     */
    public static Position start(boolean current) {
        return new Position(POSITION_EMPTY_VALUE, current);
    }

    /**
     * 맨 처음 랜덤으로 생성
     *
     * @return
     */
    public static Position start() {
        return Position.start(findRandCurrent());
    }

    /**
     * 맨 뒤 생성
     *
     * @param hasLeft
     * @return Position
     */
    public static Position end(boolean hasLeft) {
        return new Position(hasLeft, POSITION_EMPTY_VALUE);
    }

    /**
     * 생성
     *
     * @param hasLeft
     * @param current
     * @return
     */
    public static Position add(boolean hasLeft, boolean current) {
        return new Position(hasLeft, current);
    }

    /**
     * 현재값 랜덤으로 생성
     *
     * @param hasLeft
     * @return
     */
    public static Position add(boolean hasLeft) {
        return new Position(hasLeft, decideCurrent(hasLeft));
    }

    private static boolean decideCurrent(boolean hasLeft) {
        if (!hasLeft) {
            return findRandCurrent();
        }

        if (hasLeft) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    private static boolean findRandCurrent() {
        Random random = new Random();
        return random.nextBoolean();
    }

    /**
     * 포지션 이동
     *
     * @param index 위치
     * @return index
     */
    public int move(int index) {
        if (current) {
            return index + 1;
        }

        if (index != 0 && hasLeft) {
            return index - 1;
        }

        return index;
    }

    /**
     * 현재 생태 반환
     *
     * @return current
     */
    public boolean status() {
        return current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return hasLeft == position.hasLeft &&
                current == position.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasLeft, current);
    }
}
