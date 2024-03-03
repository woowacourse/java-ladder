package domain.line;

import static domain.connection.Connection.DISCONNECTION;
import static domain.connection.Connection.LEFT_CONNECTION;
import static domain.connection.Connection.RIGHT_CONNECTION;
import static org.assertj.core.api.Assertions.assertThat;

import domain.ColumnPosition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 노드 도메인 테스트")
class PointTest {

    @DisplayName("점에서 오른쪽 이동 지점을 확인할 수 있다")
    @Test
    void testNavigateRight() {
        Point point = new Point(new ColumnPosition(1), RIGHT_CONNECTION);
        assertThat(point.navigateNextPosition()).isEqualTo(new ColumnPosition(2));
    }


    @DisplayName("점에서 왼쪽 이동 지점을 확인할 수 있다")
    @Test
    void testNavigateLeft() {
        Point point = new Point(new ColumnPosition(1), LEFT_CONNECTION);
        assertThat(point.navigateNextPosition()).isEqualTo(new ColumnPosition(0));
    }


    @DisplayName("점에서 움직이지 않은 다음 이동 지점을 확인할 수 있다")
    @Test
    void testNavigateStay() {
        Point point = new Point(new ColumnPosition(1), DISCONNECTION);
        assertThat(point.navigateNextPosition()).isEqualTo(new ColumnPosition(1));
    }
}
