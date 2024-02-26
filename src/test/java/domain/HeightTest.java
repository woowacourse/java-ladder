package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @DisplayName("높이 객체를 정상적으로 생성한다.")
    @Test
    void createHeight() {
        assertThatCode(() -> new Height(5))
                .doesNotThrowAnyException();
    }

    @DisplayName("높이가 0이하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void createHeightWithUnderZero(int invalidHeight) {
        assertThatThrownBy(() -> new Height(invalidHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
