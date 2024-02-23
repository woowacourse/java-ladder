package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @Test
    @DisplayName("사다리 높이 객체를 생성한다.")
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

    @Test
    @DisplayName("사다리 높이가 같으면 서로 같은 객체이다.")
    void createSameHeight() {
        //given & when
        var height1 = new Height(10);
        var height2 = new Height(10);

        //then
        Assertions.assertThat(height1).isEqualTo(height2);
    }
}
