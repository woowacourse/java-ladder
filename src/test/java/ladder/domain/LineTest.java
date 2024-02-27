package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 라인")
public class LineTest {
    @DisplayName("생성 테스트")
    @Test
    void createTest() {
        // given
        int count = 3;
        List<Connection> expected = List.of(Connection.RUNG, Connection.EMPTY, Connection.RUNG);

        // when
        Line line = new Line(List.of(Connection.RUNG, Connection.EMPTY, Connection.RUNG));

        // then
        assertThat(line)
                .extracting("connections")
                .isEqualTo(expected);
    }

    @DisplayName("연속으로 발판이 있는 경우 예외를 발생시킨다.")
    @Test
    void continueScaffoldExceptionTest() {
        assertThatThrownBy(() -> new Line(List.of(Connection.RUNG, Connection.RUNG, Connection.EMPTY)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌우 연속해서 발판이 존재할 수 없습니다.");
    }
}
