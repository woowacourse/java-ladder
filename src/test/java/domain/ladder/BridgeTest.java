package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BridgeTest {

    @Test
    @DisplayName("boolean 값으로 Bridge 찾아오기")
    void findBridge() {
        //given
        //when
        //then
        assertAll(
                () -> assertThat(Bridge.findByHasBridge(true)).isEqualTo(Bridge.BRIDGE),
                () -> assertThat(Bridge.findByHasBridge(false)).isEqualTo(Bridge.NON_BRIDGE)
        );
    }
}
