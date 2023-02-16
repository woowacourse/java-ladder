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
    @DisplayName("0 혹은 1이 입력되면, 사다리 가로대가 생성된다.")
    void create_test(int validNumber) {
        assertDoesNotThrow(() -> Rung.create(validNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 3, 4})
    @DisplayName("0 혹은 1이 아닌 값이 입력되면, 예외가 발생한다.")
    void create_error_test(int errorNumber) {
        assertThatThrownBy(() -> Rung.create(errorNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_MATERIAL.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "0:false"}, delimiter = ':')
    @DisplayName("0 혹은 1이 아닌 값이 입력되면, 예외가 발생한다.")
    void make_rung_error_test(int material, boolean expectedValue) {
        // given
        Rung rung = Rung.create(material);

        // when
        boolean actualValue = rung.isExistence();

        // then
        assertThat(actualValue).isEqualTo(expectedValue);
    }
}
