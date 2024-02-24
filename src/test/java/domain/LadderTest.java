package domain;

import domain.Ladder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Generator;

import static org.assertj.core.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("사다리 최대 높이는 100이다.")
    void maxHeight() {
        List<Line> lines = new ArrayList<>();
        Line line = new Line(List.of(Bridge.BRIDGE, Bridge.NON_BRIDGE));

        IntStream.range(0, 101).forEach(number -> lines.add(line));

        assertThatThrownBy(() -> new Ladder(lines)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주어진 사다리의 가로 길이가 일정한지 확인한다")
    void LadderShape() {
        Line line1 = new Line(List.of(Bridge.NON_BRIDGE, Bridge.NON_BRIDGE, Bridge.NON_BRIDGE));
        Line line2 = new Line(List.of(Bridge.NON_BRIDGE, Bridge.NON_BRIDGE));
        List<Line> lines = List.of(line1, line2, line1);

        assertThatThrownBy(() -> new Ladder(lines)).isInstanceOf(IllegalArgumentException.class);
    }
}
