package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리")
public class LadderTest {
    @DisplayName("생성 테스트")
    @Test
    void createTest() {
        // given
        List<Line> expected = List.of(
                new Line(List.of(Connection.RUNG, Connection.EMPTY, Connection.RUNG)),
                new Line(List.of(Connection.EMPTY, Connection.RUNG, Connection.EMPTY)),
                new Line(List.of(Connection.RUNG, Connection.EMPTY, Connection.EMPTY)));

        // when
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(Connection.RUNG, Connection.EMPTY, Connection.RUNG)),
                new Line(List.of(Connection.EMPTY, Connection.RUNG, Connection.EMPTY)),
                new Line(List.of(Connection.RUNG, Connection.EMPTY, Connection.EMPTY))));

        // then
        assertThat(ladder)
                .extracting("lines")
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @DisplayName("라인의 개수가 1개 미만이라면 예외를 발생시킨다.")
    @Test
    void minLineTest() {
        assertThatThrownBy(() -> new Ladder(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리는 1개 이상의 라인으로 이루어져야 합니다.");
    }
}
