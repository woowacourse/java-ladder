package laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


@DisplayName("높이")
class HeightTest {
    @DisplayName("높이가 0이거나 음수이면 예외가 발생한다.")
    @ParameterizedTest(name = "value = {0}")
    @ValueSource(ints = {-3, -2, -1, 0})
    void throwExceptionWhenValueIsZeroOrNegative(final int value) {
        assertThatThrownBy(() -> new Height(value));
    }

    @DisplayName("높이가 생성된다.")
    @ParameterizedTest(name = "value = {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void create(final int value) {
        assertDoesNotThrow(() -> new Height(value));
    }

    @DisplayName("높이를 가져온다.")
    @ParameterizedTest(name = "value = {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void getValue(final int value) {
        final Height height = new Height(value);
        final int heightValue = height.getValue();
        Assertions.assertThat(heightValue).isEqualTo(value);
    }
}