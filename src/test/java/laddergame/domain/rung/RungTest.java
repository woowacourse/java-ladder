package laddergame.domain.rung;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static laddergame.domain.message.ErrorMessage.INVALID_MATERIAL;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RungTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    @DisplayName("0 혹은 1이 입력되면, 예외가 발생하지 않는다.")
    void create_thenSuccess(final int validNumber) {
        assertThatCode(() -> Rung.create(validNumber))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 3, 4})
    @DisplayName("0 혹은 1이 아닌 값이 입력되면, 예외가 발생한다.")
    void create_givenNotZeroOrOne_thenFail(final int invalidNumber) {
        assertThatThrownBy(() -> Rung.create(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_MATERIAL.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true"}, delimiter = ':')
    @DisplayName("0이 입력되면 false, 1이 입력되면 true를 반환한다.")
    void isExistence_whenGivenZeroOrOne_thenReturnFalseOrTrue(final int material, final boolean expectedValue) {
        // given
        Rung rung = Rung.create(material);

        // when
        boolean actualValue = rung.isExistence();

        // then
        assertThat(actualValue).isEqualTo(expectedValue);
    }
}
