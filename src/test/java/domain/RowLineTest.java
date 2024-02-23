package domain;

import domain.line.RowLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("가로줄 테스트")
public class RowLineTest {

    @DisplayName("특정 위치의 오른쪽이 연결이 있는지 확인할 수 있다.")
    @Test
    void testCheckRightConnection() {
        List<ConnectionStatus> connections = List.of(CONNECTED, DISCONNECTED, CONNECTED);
        RowLine rowLine = new RowLine(connections);
        assertThat(rowLine.hasRightConnection(0)).isTrue();
        assertThat(rowLine.hasRightConnection(1)).isFalse();
        assertThat(rowLine.hasRightConnection(2)).isTrue();
    }
}
