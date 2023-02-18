package laddergame.domain.rung;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static laddergame.domain.message.ErrorMessage.INVALID_MATERIAL;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RungTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    @DisplayName("0 혹은 1이 입력되면, 예외가 발생하지 않는다.")
    void does_not_throws_exception_if_input_is_0_or_1(int validMaterial) {
        assertDoesNotThrow(() -> Rung.create(validMaterial));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 3, 4})
    @DisplayName("0 혹은 1을 제외한 다른 값이 입력되면, 예외가 발생한다.")
    void throws_exception_if_input_is_not_0_or_1(int invalidMaterial) {
        assertThatThrownBy(() -> Rung.create(invalidMaterial))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_MATERIAL.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true"}, delimiter = ':')
    @DisplayName("0이 입력되면 존재하지 않고, 1이 입력되면 존재하는지 확인한다.")
    void does_not_exists_if_input_is_0_and_exists_if_input_is_1(int material, boolean expectedValue) {
        // given
        Rung rung = Rung.create(material);

        // when
        boolean actualValue = rung.exists();

        // then
        assertThat(actualValue).isEqualTo(expectedValue);
    }
}
