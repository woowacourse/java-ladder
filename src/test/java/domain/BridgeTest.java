package domain;

import static org.assertj.core.api.Assertions.assertThat;

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

}