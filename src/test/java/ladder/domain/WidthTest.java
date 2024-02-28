package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WidthTest {
    @DisplayName("입력된 첫번째 인자를 value로 가진다.")
    @Test
    void widthConstructTest() {
        Width width = new Width(2);

        assertThat(width.value()).isEqualTo(2);
    }

    @DisplayName("자연수가 아닌 너비를 입력하면 예외가 발생한다.")
    @ValueSource(ints = {0, -1})
    @ParameterizedTest
    void invalidWidthTest(int value) {
        assertThatThrownBy(() -> new Width(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("너비는 2 이상이여야 합니다: %d".formatted(value));
    }
}
