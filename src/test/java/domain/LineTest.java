package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import strategy.RandomPointStrategy;

public class LineTest {

    @Test
    @DisplayName("가로줄 생성 성공: (참여자 - 1) 만큼의 가로줄이 생성된다.")
    void test_ok_constructor() {
        Line line = new Line(3, new RandomPointStrategy());
        assertThat(line.getPoints().size()).isEqualTo(3 - 1);
    }

    @RepeatedTest(50)
    @DisplayName("가로줄 생성 성공: 랜덤으로 생성된 값이 Point 객체이다.")
    void test_ok_generateRandomPoint() {
        Line line = new Line(4, new RandomPointStrategy());
        line.getPoints()
                .forEach(point -> assertThat(point).isInstanceOf(Point.class));
    }

    @Test
    @DisplayName("가로줄 생성 성공: 연결 오른쪽은 비연결이다.")
    void test_ok_generatePointNextConnected() {
        Line line = new Line(3, () -> Point.CONNECTED);
        assertThat(line.getPoints().get(1)).isEqualTo(Point.DISCONNECTED);
    }
}
