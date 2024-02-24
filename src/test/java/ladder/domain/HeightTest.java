package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @Test
    @DisplayName("높이는 1 이상의 정수이다.")
    void createHeight() {
        // when & then
        assertThatCode(() -> new Height("1"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("입력된 높이가 0 이하라면 예외가 발생한다.")
    @ValueSource(strings = {"0", "-1"})
    void createNegativeHeight(String value) {
        // when & then
        assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력된 높이가 정수가 아니라면 예외가 발생한다.")
    @ValueSource(strings = {"height", "1.5"})
    void createNotNumber(String value) {
        // when & then
        assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
