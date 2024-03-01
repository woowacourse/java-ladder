package domain;

import static domain.Connection.LEFT_CONNECTION;
import static domain.Connection.RIGHT_CONNECTION;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("가로줄 테스트")
class RowLineTest {

    @DisplayName("현재 열의 위치에서 연결 정보를 기반으로 다음 열의 위치를 계산할 수 있다")
    @Test
    void testNavigateNextColumn() {
        RowLine rowLine = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), RIGHT_CONNECTION),
                new Point(new ColumnPosition(3), LEFT_CONNECTION)
        ));

        assertThat(rowLine.nextPosition(new ColumnPosition(0))).isEqualTo(new ColumnPosition(1));
        assertThat(rowLine.nextPosition(new ColumnPosition(1))).isEqualTo(new ColumnPosition(0));
        assertThat(rowLine.nextPosition(new ColumnPosition(2))).isEqualTo(new ColumnPosition(3));
        assertThat(rowLine.nextPosition(new ColumnPosition(3))).isEqualTo(new ColumnPosition(2));
    }

    @DisplayName("특정 위치의 연결을 조회할 수 있다")
    @Test
    void testCheckRightConnection() {
        RowLine rowLine = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), RIGHT_CONNECTION),
                new Point(new ColumnPosition(3), LEFT_CONNECTION)
        ));
        assertThat(rowLine.getPointAt(new ColumnPosition(0)).getConnection()).isEqualTo(RIGHT_CONNECTION);
        assertThat(rowLine.getPointAt(new ColumnPosition(1)).getConnection()).isEqualTo(LEFT_CONNECTION);
        assertThat(rowLine.getPointAt(new ColumnPosition(2)).getConnection()).isEqualTo(RIGHT_CONNECTION);
        assertThat(rowLine.getPointAt(new ColumnPosition(3)).getConnection()).isEqualTo(LEFT_CONNECTION);
    }

    @DisplayName("Point 개수를 확인할 수 있다")
    @Test
    void testCalculateConnectionCount() {
        RowLine rowLine = new RowLine(List.of(
                new Point(new ColumnPosition(0), RIGHT_CONNECTION),
                new Point(new ColumnPosition(1), LEFT_CONNECTION),
                new Point(new ColumnPosition(2), RIGHT_CONNECTION),
                new Point(new ColumnPosition(3), LEFT_CONNECTION)
        ));
        assertThat(rowLine.getPointCount()).isEqualTo(4);
    }
}
