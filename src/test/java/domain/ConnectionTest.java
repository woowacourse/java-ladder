package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomConnectionStrategy;

public class ConnectionTest {

    @Test
    @DisplayName("생성 성공: 연결 다음은 무조건 비연결이다.")
    void test_ok_makeNextConnectionOfConnected() {
        Connection now = Connection.CONNECTED;
        Connection next = now.makeNextConnection(new RandomConnectionStrategy());
        Assertions.assertThat(next).isEqualTo(Connection.DISCONNECTED);
    }

    @Test
    @DisplayName("생성 성공: 비연결 다음은 전략에 따른다. - 무조건 연결을 반환하도록 하는 전략")
    void test_ok_makeNextConnectionOfDisconnectedByConnectedStrategy() {
        Connection now = Connection.DISCONNECTED;
        Connection next = now.makeNextConnection(new RandomConnectionStrategy() {
            @Override
            public Connection generateConnection() {
                return Connection.CONNECTED;
            }
        });
        Assertions.assertThat(next).isEqualTo(Connection.CONNECTED);
    }

    @Test
    @DisplayName("생성 성공: 비연결 다음은 전략에 따른다. - 무조건 비연결을 반환하도록 하는 전략")
    void test_ok_makeNextConnectionOfDisconnectedByDisconnectedStrategy() {
        Connection now = Connection.DISCONNECTED;
        Connection next = now.makeNextConnection(new RandomConnectionStrategy() {
            @Override
            public Connection generateConnection() {
                return Connection.DISCONNECTED;
            }
        });
        Assertions.assertThat(next).isEqualTo(Connection.DISCONNECTED);
    }
}
