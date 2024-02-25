package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @Test
    @DisplayName("높이는 1 이상의 숫자이다.")
    void createHeight() {
        // when & then
        assertThatCode(() -> new Height("1"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("입력된 높이가 0 이하라면 예외가 발생한다.")
    void createNegativeHeight(String height) {
        // when & then
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 높이가 숫자가 아니라면 예외가 발생한다.")
    void createNotNumber() {
        // when & then
        assertThatThrownBy(() -> new Height("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
