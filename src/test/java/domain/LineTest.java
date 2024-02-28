package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import strategy.RandomConnectionStrategy;

public class LineTest {

    @Test
    @DisplayName("가로줄 생성 성공: (참여자 - 1) 만큼의 가로줄이 생성된다.")
    void test_ok_constructor() {
        Line line = Line.of(3, new RandomConnectionStrategy());
        assertThat(line.getConnections().size()).isEqualTo(3 - 1);
    }

    @RepeatedTest(50)
    @DisplayName("가로줄 생성 성공: 랜덤으로 생성된 값이 Connection 객체이다.")
    void test_ok_generateRandomPoint() {
        Line line = Line.of(4, new RandomConnectionStrategy());
        line.getConnections()
                .forEach(connection -> assertThat(connection).isInstanceOf(Connection.class));
    }

    @Test
    @DisplayName("가로줄 생성 성공: 연결 오른쪽은 항상 비연결이다.")
    void test_ok_generatePointNextConnected() {
        Line line = Line.of(3, () -> Connection.CONNECTED);
        assertThat(line.getConnections().get(1)).isEqualTo(Connection.DISCONNECTED);
    }

    @Test
    @DisplayName("가로줄 생성 성공: 절대 연속으로 사다리가 연결될 수 없다.")
    void test_ok_cannotConnectContinuously() {
        Line line = Line.of(3, () -> Connection.CONNECTED);
        assertThat(line.getConnections().get(1)).isNotEqualTo(Connection.CONNECTED);
    }
}
