package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("값이 2보다 작으면 예외가 발생한다")
    void createHeightLessThan2(int height) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 10})
    @DisplayName("값이 2 이상인 자연수면 성공")
    void createHeightOverThan2(int height) {
        //given
        //when
        //then
        Assertions.assertDoesNotThrow(() -> new Height(height));
    }
}