package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리")
public class LadderTest {
    @DisplayName("생성한다.")
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
}
