package laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


@DisplayName("높이")
class HeightTest {

    @DisplayName("높이가 0이거나 음수이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void throwExceptionWhenValueIsZeroOrNegative(final int value) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Height(value));
    }

    @DisplayName("높이가 생성된다.")
    @Test
    void create() {
        //given
        //when
        //then
        assertDoesNotThrow(() -> new Height(1));
    }

    @DisplayName("높이를 가져온다.")
    @Test
    void getValue() {
        //given
        final Height height = new Height(1);

        //when
        final int heightValue = height.getValue();

        //then
        Assertions.assertThat(heightValue).isEqualTo(1);
    }
}
