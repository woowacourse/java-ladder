package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import strategy.ConnectStrategy;
import strategy.RandomConnectStrategy;

public class LineTest {

    private final ConnectStrategy randomConnectStrategy = new RandomConnectStrategy();

    @Test
    @DisplayName("Line 생성 성공: (참여자 - 1) 만큼의 Line이 생성된다.")
    void test_ok_constructor() {
        Line line = Line.of(randomConnectStrategy, 3);
        assertThat(line.getConnections().size()).isEqualTo(3 - 1);
    }

    @RepeatedTest(50)
    @DisplayName("Line 생성 성공: 랜덤으로 생성된 값이 Connection 객체이다.")
    void test_ok_generateRandomConnection() {
        Line line = Line.of(randomConnectStrategy, 4);
        line.getConnections()
            .forEach(connection -> assertThat(connection).isInstanceOf(Connection.class));
    }

    @Test
    @DisplayName("Line 생성 성공: 연결 오른쪽은 비연결이다.")
    void test_ok_ifLeftConnected_rightDisconnected() {
        Line line = Line.of(() -> Connection.CONNECTED, 3);
        assertThat(line.getConnections().get(1)).isEqualTo(Connection.DISCONNECTED);
    }

    @Test
    @DisplayName("성공: 현재 Line을 지난 후의 인덱스를 정상적으로 찾는다")
    void test_ok_findNextIndex() {
        Line line = Line.of(() -> Connection.CONNECTED, 4); // |-----|     |-----|
        Assertions.assertAll(
            () -> assertThat(line.findNextIndex(0)).isEqualTo(1),
            () -> assertThat(line.findNextIndex(1)).isEqualTo(0),
            () -> assertThat(line.findNextIndex(2)).isEqualTo(3),
            () -> assertThat(line.findNextIndex(3)).isEqualTo(2)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    @DisplayName("실패: index 범위 넘어가는 경우")
    void test_exception_findNextIndex(int index) {
        Line line = Line.of(() -> Connection.CONNECTED, 4);
        assertThatThrownBy(() -> line.findNextIndex(index))
            .isInstanceOf(IllegalStateException.class);
    }
}
