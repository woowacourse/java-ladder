package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    @DisplayName("boolean 값에 따른 Bridge 객체 생성 테스트")
    void generateBridgeFromBoolean() {
        //given
        boolean generate = true;
        boolean nonGenerate = false;

        //when
        //then
        assertThat(Bridge.from(generate)).isEqualTo(Bridge.CONNECTED);
        assertThat(Bridge.from(nonGenerate)).isEqualTo(Bridge.UNCONNECTED);
    }

    @Test
    @DisplayName("Bridge 객체 목록을 연결 상태 값으로 변환한다")
    void convertToConnectionStatus() {
        //given
        List<Bridge> bridges = List.of(Bridge.CONNECTED, Bridge.UNCONNECTED, Bridge.UNCONNECTED, Bridge.CONNECTED);

        //when
        List<Boolean> bridgeConnections = Bridge.convertToConnectionStatus(bridges);

        //then
        assertThat(bridgeConnections).containsExactly(true, false, false, true);
    }
}