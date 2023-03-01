package ladder.domain;

import ladder.FixedLineStrategy;
import ladder.domain.ladderNode.Position;
import ladder.utils.LineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("line에 연속적인 다리가 존재하면 예외를 던진다.")
    void line_generate_exception_if_continuous() {
        // given
        List<List<Boolean>> parts = List.of(List.of(false, true, true, false));
        FixedLineStrategy fixedLineStrategy = new FixedLineStrategy(parts);

        // expected
        assertThatThrownBy(() -> new Line(fixedLineStrategy, 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라인에 연속으로 연결된 다리는 생성될 수 없습니다.");
    }

    @Test
    @DisplayName("LineStrategy로부터 line을 생성한다.")
    void line_generateFromLineStrategy() {
        // given
        List<List<Boolean>> parts = List.of(List.of(true, false, true, false));
        FixedLineStrategy fixedLineStrategy = new FixedLineStrategy(parts);

        // when
        Line line = new Line(fixedLineStrategy, 4);

        // expected
        assertThat(line.getLine()).containsExactly(true, false, true, false);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("라인의 범위를 벗어난 시작점에 대해서는 예외를 던진다.")
    void line_move_from_when_out_bound(int start) {
        //given
        LineStrategy fixedStrategy = new FixedLineStrategy(List.of(List.of(true, false, true)));
        Line line = new Line(fixedStrategy, 3);

        assertThatThrownBy(() -> {
            line.moveFrom(Position.from(start));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("line 범위 밖의 시작점입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2", "4:4"}, delimiter = ':')
    @DisplayName("시작점에서 라인을 따라 움직인 도착점을 계산한다.")
    void line_move_from_start_position(int start, int expected) {
        //given
        LineStrategy fixedStrategy = new FixedLineStrategy(List.of(List.of(true, false, true, false)));
        Line line = new Line(fixedStrategy, 4);
        // |--|  |--|  |

        //when
        Position arrive = line.moveFrom(Position.from(start));

        //then
        assertThat(arrive).isEqualTo(Position.from(expected));
    }
}
