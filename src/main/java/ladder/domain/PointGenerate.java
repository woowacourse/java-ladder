package ladder.domain;

/**
 * Point class의 값을 결정하는 객체
 * <br> 기본적인 사다리 설정 이외 변경될 수 있는 부분은 PointGenerateFactory 사용
 *
 * @author heebg
 * @version 1.0 2019-05-23
 */
public interface PointGenerate {
    String ILLEGAL_ARGUMENT_EXCEPTION = "유효하지 않은 값입니다.";

    default Point generatePoint(Point prePoint) {
        if (prePoint.equals(Point.LEFT)) {
            return Point.STRAIGHT;
        }

        if (prePoint.equals(Point.RIGHT)) {
            return Point.LEFT;
        }

        if (prePoint.equals(Point.STRAIGHT)) {
            return generate(prePoint);
        }

        throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION);
    }

    Point generate(Point prePoint);
}
