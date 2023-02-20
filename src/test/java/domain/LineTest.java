package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("이전 다리가 연결되었다면 이번 다리는 연결하지 않는다.")
    @Test
    void currentPointShouldBeDisconnectedWhenPreviousPointIsConnected() {
        Line line = new Line(new TestBooleanGenerator(Lists.newArrayList(true)), 3);
        assertThat(line.getPoints()).containsExactly(Point.CONNECTED, Point.DISCONNECTED);
    }
}
