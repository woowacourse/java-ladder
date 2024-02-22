package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 3"})
    @DisplayName("정상적인 다리는 예외를 발생하지 않는다.")
    void valid_bridge_case_doesnt_throw_exception(int from, int height) {
        assertDoesNotThrow(() -> new Bridge(from, height));
    }

    @ParameterizedTest
    @CsvSource({"-1, 0", "0, -1"})
    @DisplayName("다리를 잘못 연결하면 예외가 발생한다")
    void invalid_bridge_throws_exception(int from, int height) {
        Assertions.assertThatThrownBy(() -> new Bridge(from, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 연결을 하면 예외가 발생한다");
    }

    @Test
    @DisplayName("인접한 다리면 true를 반환한다")
    void adjacent_bridge_return_true() {
        Bridge bridgeA = new Bridge(0, 0);
        Bridge bridgeB = new Bridge(1, 0);
        assertThat(bridgeA.isAdjacent(bridgeB)).isTrue();
        assertThat(bridgeB.isAdjacent(bridgeA)).isTrue();
    }

    @Test
    @DisplayName("인접한 다리가 아니면 false를 반환한다")
    void not_adjacent_bridge_return_false() {
        Bridge bridgeA = new Bridge(0, 1);
        Bridge bridgeB = new Bridge(1, 0);
        assertThat(bridgeA.isAdjacent(bridgeB)).isFalse();
    }



}
