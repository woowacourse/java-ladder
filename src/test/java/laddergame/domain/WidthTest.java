package laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("넓이")
class WidthTest {
    @DisplayName("넓이가 0이거나 음수이면 예외가 발생한다.")
    @ParameterizedTest(name = "value = {0}")
    @ValueSource(ints = {-3, -2, -1, 0})
    void throwExceptionWhenValueIsZeroOrNegative(final int value) {
        assertThatThrownBy(() -> new Width(value));
    }

    @DisplayName("넓이가 생성된다.")
    @ParameterizedTest(name = "value = {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void create(final int value) {
        assertDoesNotThrow(() -> new Width(value));
    }

    @DisplayName("넓이가 가져온다.")
    @ParameterizedTest(name = "value = {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void getValue(final int value) {
        final Width width = new Width(value);
        final int widthValue = width.getValue();
        Assertions.assertThat(widthValue).isEqualTo(value);
    }
}
