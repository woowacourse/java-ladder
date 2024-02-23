package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static model.Height.NOT_POSITIVE_HEIGHT;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @Test
    @DisplayName("높이가 양수일 시 생성될 수 있다.")
    void createHeight() {
        assertThatCode(() -> new Height(1))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("높이가 양수가 아닐 시 예외가 발생한다.")
    void validateHeightIsPositive() {
        assertThatThrownBy(() -> new Height(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_POSITIVE_HEIGHT);
    }
}