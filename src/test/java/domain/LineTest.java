package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LineTest {

    @DisplayName("이전 다리가 연결되었다면 이번 다리는 연결하지 않는다.")
    @Test
    void currentPointShouldBeDisconnectedWhenPreviousPointIsConnected() {
        Line line = new Line(new TestBooleanGenerator(Lists.newArrayList(true)), 3);
        assertThat(line.getPoints()).containsExactly(Point.CONNECTED, Point.DISCONNECTED);
    }

    @DisplayName("양옆에 다리가 없으면 위치를 그대로 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,0", "3,3"})
    void shouldReturnOriginalIndexWhenPointIsDisconnected(int index, int expected) {
        Line line = new Line(new TestBooleanGenerator(Lists.newArrayList(false, true)), 4);
        assertThat(line.move(index)).isEqualTo(expected);
    }

    @DisplayName("양옆에 다리가 있으면 이동한 위치를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,2", "2,1"})
    void shouldReturnMovedIndexWhenPointIsConnected(int index, int expected) {
        Line line = new Line(new TestBooleanGenerator(Lists.newArrayList(false, true)), 4);
        assertThat(line.move(index)).isEqualTo(expected);
    }
}
