package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
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

    @DisplayName("연결 부분이 1개 미만인 경우 예외를 발생시킨다.")
    @Test
    void minConnectionTest() {
        assertThatThrownBy(() -> new Line(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라인은 1개 이상의 연결로 이루어져야 합니다.");
    }

    @DisplayName("연속으로 발판이 있는 경우 예외를 발생시킨다.")
    @Test
    void continueConnectionExceptionTest() {
        assertThatThrownBy(() -> new Line(List.of(Connection.RUNG, Connection.RUNG, Connection.EMPTY)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌우 연속해서 발판이 존재할 수 없습니다.");
    }

    @DisplayName("레일 오른쪽에 발판이 있으면 오른쪽으로 움직인다.")
    @Test
    void leftMoveTest() {
        // given
        Line line = new Line(List.of(Connection.RUNG, Connection.EMPTY));

        // when & then
        assertThat(line.climb(0)).isEqualTo(1);
    }

    @DisplayName("레일 왼쪽에 발판이 있으면 왼쪽으로 움직인다.")
    @Test
    void rightMoveTest() {
        // given
        Line line = new Line(List.of(Connection.RUNG, Connection.EMPTY));

        // when & then
        assertThat(line.climb(1)).isEqualTo(0);
    }

    @DisplayName("레일 양쪽에 발판이 없다면 움직이지 않는다.")
    @Test
    void notMoveTest() {
        // given
        Line line = new Line(List.of(Connection.RUNG, Connection.EMPTY));

        // when & then
        assertThat(line.climb(2)).isEqualTo(2);
    }
}
