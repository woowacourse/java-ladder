package laddergame.domain;

import laddergame.domain.bridge.Bridge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @DisplayName("boolean값으로 Bridge객체를 생성할 수 있다.")
    @Test
    void create() {
        // given&when
        final Bridge bridge = Bridge.from(true);

        // then
        Assertions.assertThat(bridge.name()).isEqualTo(Bridge.EXIST.name());
    }

    @DisplayName("존재하면 true값을 반환한다.")
    @Test
    void isExist() {
        // given
        final Bridge bridge = Bridge.EXIST;

        // when
        final boolean result = bridge.isExist();

        // then
        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("존재하지 않으면 false값을 반환한다.")
    @Test
    void notExist() {
        // given
        final Bridge bridge = Bridge.EMPTY;

        // when
        final boolean result = bridge.isExist();

        // then
        Assertions.assertThat(result).isFalse();
    }
}
