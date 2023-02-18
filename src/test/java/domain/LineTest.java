package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.numbergenerator.TestNumberGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("인접한 왼쪽 가로줄에 연결구조가 있다면 현재 가로줄에서는 연결구조를 놓지 않는다.")
    @Test
    void createLineTest() {
        Line line = new Line(4, new TestNumberGenerator(Lists.newArrayList(1, 1, 1)));
        assertThat(line.getPoints()).containsExactly(Point.CONNECTION, Point.SEPARATION, Point.CONNECTION);
    }

    @DisplayName("인접한 왼쪽 가로줄의 연결구조가 없다면 현재 가로줄에서는 전달받은 값을 통해 연결구조를 놓을지 말지 결정한다.")
    @Test
    void createLineTest2() {
        Line line = new Line(4, new TestNumberGenerator(Lists.newArrayList(1, 0, 0)));
        assertThat(line.getPoints()).containsExactly(Point.CONNECTION, Point.SEPARATION, Point.SEPARATION);
    }
}
