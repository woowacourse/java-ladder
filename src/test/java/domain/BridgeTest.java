package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

    @ParameterizedTest
    @CsvSource({"0, 1, 0", "1, 2, 3"})
    @DisplayName("정상적인 다리는 예외를 발생하지 않는다.")
    void valid_bridge_case_doesnt_throw_exception(int from, int to, int height) {
        assertDoesNotThrow(() -> new Bridge(from, to, height));
    }

    @ParameterizedTest
    @CsvSource({"0, 0, 0", "0, 1, -1"})
    @DisplayName("다리를 잘못 연결하면 예외가 발생한다")
    void invalid_bridge_throws_exception(int from, int to, int height) {
        Assertions.assertThatThrownBy(() -> new Bridge(from, to, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 연결을 하면 예외가 발생한다");
    }

}