package ladder.domain.ladder;

import ladder.FixedLineStrategy;
import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("LineStrategy로부터 line을 생성한다.")
    void line_generateFromLineStrategy() {
        // given
        List<List<Boolean>> parts = List.of(List.of(true, false, true, false));
        FixedLineStrategy fixedLineStrategy = new FixedLineStrategy(parts);

        // when
        Line line = new Line(fixedLineStrategy, 4);

        // expected
        assertThat(line.getSteps()).containsExactly(true, false, true, false);
    }

    @Test
    @DisplayName("위치를 입력받아 다음으로 이동할 위치를 리턴한다.")
    void line_returnNextPosition() {
        /*
          1    2    3    4
          |----|    |----|
          |    |----|    |
          |----|    |----|
          4    2    3    1
         */

        // given
        Position position = new Position(0);
        Line line = new Line(new FixedLineStrategy(List.of(List.of(true, false, true))), 2);

        // expected
        assertThat(line.findNextPosition(position))
                .isEqualTo(new Position(1));
    }
}
