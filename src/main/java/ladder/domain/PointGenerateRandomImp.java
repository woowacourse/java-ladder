package ladder.domain;

import java.util.Random;

/**
 * Point class의 값을 결정하는 객체
 * <br> 기본적인 사다리 설정 이외 변경될 수 있는 부분은 PointGenerateFactory 사용
 *
 * @author heebg
 * @version 1.0 2019-05-23
 */
public class PointGenerateRandomImp implements PointGenerate {
    private static final String ILLEGAL_ARGUMENT_EXCEPTION = "유효하지 않은 값입니다.";

    @Override
    public Point generate(Point prePoint) {
        boolean state = new Random().nextBoolean();

        if (state) {
            return Point.RIGHT;
        }
        if (!state) {
            return Point.STRAIGHT;
        }

        throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION);
    }

    @Override
    public Point generateEndPoint(Point prePoint) {
        if (prePoint.equals(Point.RIGHT)) {
            return Point.LEFT;
        }

        return Point.STRAIGHT;
    }
}
