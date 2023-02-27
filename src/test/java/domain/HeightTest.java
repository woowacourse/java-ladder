package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {
    @ParameterizedTest()
    @ValueSource(strings = {"aa", "2147483648"})
    @DisplayName("값이 정수가 아니면 예외가 발생한다")
    void createHeightNotInteger(String height) {
        //given
        //when
        //then
        assertThatThrownBy(() -> Height.from(height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("값이 2보다 작으면 예외가 발생한다")
    void createHeightLessThan2() {
        //given
        String height = "1";
        //when
        //then
        assertThatThrownBy(() -> Height.from(height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "10"})
    @DisplayName("값이 2 이상인 자연수면 성공")
    void createHeightOverThan2(String height) {
        //given
        //when
        Height heightObject = Height.from(height);

        //then
        assertThat(heightObject.getHeight()).isEqualTo(Integer.parseInt(height));
    }
}
