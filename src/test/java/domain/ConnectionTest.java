package domain;

import static domain.Connection.CONNECTED;
import static domain.Connection.DISCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConnectionTest {

    @Test
    @DisplayName("CONNECTED의 오른쪽에는 DISCONNECTED가 온다.")
    void findNextConnection_connected_disconnected() {
        assertThat(CONNECTED.findNextConnection(() -> CONNECTED)).isEqualTo(DISCONNECTED);
    }

    @Test
    @DisplayName("항상 CONNECTED를 만드는 전략에서, DISCONNECTED의 오른쪽에는 CONNECTED가 온다.")
    void findNextConnection_disconnected_connected() {
        assertThat(DISCONNECTED.findNextConnection(() -> CONNECTED)).isEqualTo(CONNECTED);
    }
}
