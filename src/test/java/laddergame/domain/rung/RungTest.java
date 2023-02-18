package laddergame.domain.rung;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RungTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("true 혹은 false가 입력되면, 예외가 발생하지 않는다.")
    void create_thenSuccess(final boolean validNumber) {
        assertThatCode(() -> Rung.create(validNumber))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {"true:true", "false:false"}, delimiter = ':')
    @DisplayName("true가 입력되면 true, false가 입력되면 false를 반환한다.")
    void isExistence_givenTrueOrFalse_thenReturnFalseOrTrue(final boolean material, final boolean expectedValue) {
        // given
        Rung rung = Rung.create(material);

        // when
        boolean actualValue = rung.isExistence();

        // then
        assertThat(actualValue).isEqualTo(expectedValue);
    }
}
