package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import strategy.RandomPointStrategy;

public class LineTest {

    /* TODO: true 연속 2개 나오는 테스트 케이스 어떻게 만들지 생각해보기
    @Test
    @DisplayName("true-true 쌍이 발견될 경우 에러를 반환한다.")
    void test_exception_findTrueTrue() {
    }
     */

    @RepeatedTest(1000)
    @DisplayName("랜덤으로 만든 값이 true 또는 false이다.")
    void test() {
        Line line = new Line(4, new RandomPointStrategy());
        line.getPoints().forEach(
                point -> assertThat(point).isInstanceOf(Boolean.class));
    }

    @Test
    @DisplayName("true가 나오면 그 다음은 무조건 false가 된다.")
    void test_ok_trueNextFalse() {
        Line line = new Line(3, () -> Point.CONNECTED);
        assertThat(line.getPoints().get(1)).isEqualTo(Point.DISCONNECTED);
    }
}
