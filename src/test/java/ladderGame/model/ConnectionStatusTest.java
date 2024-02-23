package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionStatusTest {

    @Test
    @DisplayName("ConnectionStatus가 CONNECTION이면 true를 반환한다.")
    void checkConnectionIsTrue() {
        ConnectionStatus connectionStatus = ConnectionStatus.CONNECTION;

        assertTrue(connectionStatus.equals(ConnectionStatus.CONNECTION));
    }

    @Test
    @DisplayName("ConnectionStatus가 DISCONNECTION이면 false를 반환한다.")
    void checkNonConnectionIsFalse() {
        ConnectionStatus connectionStatus = ConnectionStatus.DISCONNECTION;

        assertFalse(connectionStatus.equals(ConnectionStatus.CONNECTION));
    }

}