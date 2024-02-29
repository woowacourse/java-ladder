package domain;

import static domain.Connection.CONNECTED;
import static domain.Connection.DISCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConnectionTest {

    @Test
    @DisplayName("성공: 다음 Connection을 잘 받아 온다.")
    void test_ok_findNextConnection() {
        assertAll(
            () -> assertThat(CONNECTED.findNextConnection(() -> CONNECTED)).isEqualTo(DISCONNECTED),
            () -> assertThat(DISCONNECTED.findNextConnection(() -> CONNECTED)).isEqualTo(CONNECTED)
        );
    }
}
