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
        assertThat(rowLine.getConnection(0)).isEqualTo(CONNECTED);
        assertThat(rowLine.getConnection(1)).isEqualTo(DISCONNECTED);
        assertThat(rowLine.getConnection(2)).isEqualTo(CONNECTED);
    }
}
