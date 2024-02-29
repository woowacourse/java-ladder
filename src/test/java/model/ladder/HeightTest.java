package model.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @Test
    @DisplayName("사다리 높이 객체 생성")
    void createHeight() {
        Assertions.assertThatCode(() -> new Height(5))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("올바르지 않는 사다리 높이가 들어오면 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 13})
    void invalidHeight(int value) {
        Assertions.assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
