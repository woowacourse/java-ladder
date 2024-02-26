package domain;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("가로줄 테스트")
class RowLineTest {

    @DisplayName("특정 위치의 오른쪽이 연결이 있는지 확인할 수 있다.")
    @Test
    void testCheckRightConnection() {
        List<ConnectionStatus> connections = List.of(CONNECTED, DISCONNECTED, CONNECTED);
        RowLine rowLine = new RowLine(connections);
        assertThat(rowLine.getRightConnection(0)).isEqualTo(CONNECTED);
        assertThat(rowLine.getRightConnection(1)).isEqualTo(DISCONNECTED);
        assertThat(rowLine.getRightConnection(2)).isEqualTo(CONNECTED);
    }

    @DisplayName("특정 위치의 왼쪽이 연결이 있는지 확인할 수 있다.")
    @Test
    void testCheckLeftConnection() {
        List<ConnectionStatus> connections = List.of(CONNECTED, DISCONNECTED, CONNECTED);
        RowLine rowLine = new RowLine(connections);
        assertThat(rowLine.getLeftConnection(1)).isEqualTo(CONNECTED);
        assertThat(rowLine.getLeftConnection(3)).isEqualTo(CONNECTED);
        assertThat(rowLine.getLeftConnection(2)).isEqualTo(DISCONNECTED);
    }

    @DisplayName("오른쪽 연결을 물을 때 인덱스를 벗어난다면 DISCONNECT를 반환한다.")
    @Test
    void testCheckRightConnectionAtEnd() {
        List<ConnectionStatus> connections = List.of(CONNECTED, DISCONNECTED, CONNECTED);
        RowLine rowLine = new RowLine(connections);
        assertThat(rowLine.getRightConnection(3)).isEqualTo(DISCONNECTED);
    }

    @DisplayName("왼쪽 연결을 물을 때 인덱스를 벗어난다면 DISCONNECT를 반환한다.")
    @Test
    void testCheckLeftConnectionAtStart() {
        List<ConnectionStatus> connections = List.of(CONNECTED, DISCONNECTED, CONNECTED);
        RowLine rowLine = new RowLine(connections);
        assertThat(rowLine.getLeftConnection(0)).isEqualTo(DISCONNECTED);
    }

    @DisplayName("연결 개수를 확인할 수 있다")
    @Test
    void testCalculateConnectionCount() {
        List<ConnectionStatus> connections = List.of(CONNECTED, DISCONNECTED, CONNECTED);
        RowLine rowLine = new RowLine(connections);
        assertThat(rowLine.getConnectionCount()).isEqualTo(3);
    }
}
