package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {
    @Test
    @DisplayName("true or false가 주어졌을 때 그에 맞는 enum 객체를 반환한다")
    void findByHasLine() {
        assertAll(
                () -> assertThat(Bridge.findByHasLine(true)).isEqualTo(Bridge.BRIDGE),
                () -> assertThat(Bridge.findByHasLine(false)).isEqualTo(Bridge.NON_BRIDGE)
        );
    }
}
