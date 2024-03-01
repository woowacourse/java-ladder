package ladder.domain.attribute;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WidthTest {

    @DisplayName("자연수가 아닌 값을 입력하면 예외가 발생한다.")
    @ValueSource(ints = {0, -1})
    @ParameterizedTest
    void invalidWidthTest(int value) {
        assertThatThrownBy(() -> new Width<>(value))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("자연수가 아닙니다");
    }
}
