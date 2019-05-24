package ladder.domain;

import java.util.function.Function;

/**
 * 사다리의 한 점을 나타내는 객체
 * <br> 사다리 방향을 나타낸다.
 * <br> LEFT, STRAIGHT, RIGHT
 *
 * @author heebg
 * @version 1.0 2019-05-22
 */
public enum  Point {
    LEFT(index -> index - 1 ),
    STRAIGHT(index -> index),
    RIGHT(index -> index + 1);

    private Function<Integer,Integer> expression;

    Point(Function<Integer,Integer> expression) {
        this.expression = expression;
    }

    public int move(int index) {
        return expression.apply(index);
    }
}
