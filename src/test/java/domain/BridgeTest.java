package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    @DisplayName("boolean값에 따라 알맞은 bridge인스턴스를 반환한다.")
    void from() {
        Assertions.assertThat(Bridge.from(true)).isEqualTo(Bridge.EXIST);
        Assertions.assertThat(Bridge.from(false)).isEqualTo(Bridge.NON_EXIST);
    }
}
