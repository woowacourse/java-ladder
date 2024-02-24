package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("사다리 최대 높이는 100이다.")
    void maxHeightTest() {
        final List<Line> lines = new ArrayList<>();
        final Line line = new Line(List.of(Bridge.BRIDGE, Bridge.NON_BRIDGE));
        IntStream.range(0, 101).forEach(number -> lines.add(line));

        assertThatThrownBy(() -> new Ladder(lines)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주어진 사다리의 가로 길이가 일정한지 확인한다")
    void LadderShapeTest() {
        final Line line1 = new Line(List.of(Bridge.NON_BRIDGE, Bridge.NON_BRIDGE, Bridge.NON_BRIDGE));
        final Line line2 = new Line(List.of(Bridge.NON_BRIDGE, Bridge.NON_BRIDGE));
        List<Line> lines = List.of(line1, line2, line1);

        assertThatThrownBy(() -> LadderFactory.createLadder(lines)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,1", "2,2", "3,3"})
    @DisplayName("사다리 게임을 실행 했을 때 브릿지가 놓여있지 않으면 같은 위치의 값을 반환한다")
    void nonBridgeTest(final int startPosition, final int expected) {
        final Line line = new Line(List.of(Bridge.NON_BRIDGE, Bridge.NON_BRIDGE, Bridge.NON_BRIDGE));
        final List<Line> lines = List.of(line, line, line);
        final Ladder ladder = LadderFactory.createLadder(lines);

        final int endPosition = ladder.playByPosition(startPosition);

        assertThat(endPosition).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,3", "1,0", "2,1", "3,2"})
    @DisplayName("사다리 게임을 실행 했을 때 올바른 결과를 반환한다")
    void gameResultTest(final int startPosition, final int expected) {
        final Line line1 = new Line(List.of(Bridge.BRIDGE, Bridge.NON_BRIDGE, Bridge.NON_BRIDGE));
        final Line line2 = new Line(List.of(Bridge.NON_BRIDGE, Bridge.BRIDGE, Bridge.NON_BRIDGE));
        final Line line3 = new Line(List.of(Bridge.NON_BRIDGE, Bridge.NON_BRIDGE, Bridge.BRIDGE));
        final List<Line> lines = List.of(line1, line2, line3);
        final Ladder ladder = LadderFactory.createLadder(lines);

        final int endPosition = ladder.playByPosition(startPosition);

        assertThat(endPosition).isEqualTo(expected);
    }
}
