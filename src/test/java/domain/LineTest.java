package domain;

import domain.ladder.Line;
import domain.ladder.Point;
import domain.booleangenerator.TestBooleanGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @DisplayName("인접한 왼쪽 가로줄에 연결구조가 있다면 현재 가로줄에서는 연결구조를 놓지 않는다.")
    @Test
    void createLineTest() {
        Line line = new Line(4, new TestBooleanGenerator(Lists.newArrayList(true, true, true)));
        assertThat(line.getLine()).containsExactly(Point.CONNECTION, Point.SEPARATION, Point.CONNECTION);
    }

    @DisplayName("인접한 왼쪽 가로줄의 연결구조가 없다면 현재 가로줄에서는 전달받은 값을 통해 연결구조를 놓을지 말지 결정한다.")
    @Test
    void createLineTest2() {
        Line line = new Line(4, new TestBooleanGenerator(Lists.newArrayList(true, false, false)));
        assertThat(line.getLine()).containsExactly(Point.CONNECTION, Point.SEPARATION, Point.SEPARATION);
    }

    @DisplayName("사다리의 어떤 한 가로줄은 주어진 인덱스 번호의 연결구조가 연결되어있다면 true를 반환한다.")
    @Test
    void isConnectedTest_1() {
        Line line = new Line(4, new TestBooleanGenerator(Lists.newArrayList(true, false, false)));
        assertThat(line.isConnected(0)).isTrue();
    }

    @DisplayName("사다리의 어떤 한 가로줄은 주어진 인덱스 번호의 연결구조가 연결되어있지 않다면 false를 반환한다.")
    @Test
    void isConnectedTest_2() {
        Line line = new Line(4, new TestBooleanGenerator(Lists.newArrayList(true, false, false)));
        assertThat(line.isConnected(1)).isFalse();
    }

    @DisplayName("사다리의 어떤 한 가로줄이 연결되어있는지를 판단할 때 잘못된 범위의 인덱스를 전달할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void isConnedtedTest_3(int index) {
        Line line = new Line(4, new TestBooleanGenerator(Lists.newArrayList(true, false, false)));
        assertThatThrownBy(() -> line.isConnected(index))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 가로줄의 번호는 0부터 플레이어 수 - 1까지의 범위를 갖는 정수로 입력해주세요.");
    }
}
