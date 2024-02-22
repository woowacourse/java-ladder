package domain;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;
import static domain.ConnectionStatus.getAllStatus;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("연결 상태 상수 클래스 테스트")
class ConnectionStatusTest {

    @DisplayName("리스트로 반환 요청시 모든 상태를 담고 있는다")
    @Test
    void testGetAllStatus() {
        Assertions.assertThat(getAllStatus()).containsAll(List.of(CONNECTED, DISCONNECTED));
    }
}
