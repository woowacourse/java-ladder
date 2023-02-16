package utils.constants;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Validator;

class ValidatorTest {

    @Test
    @DisplayName("이름이 1글자 이상, 다섯글자 이하면 예외가 발생하지 않는다.")
    void validateNameSuccessTest() {
        assertThatCode(() -> Validator.validateName("a"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "이름이 1글자 미만, 다섯글자 초과면 예외가 발생한다. 입력값 = {0}")
    @ValueSource(strings = {"", "adfasd"})
    void validateNameFailureTest(String input) {
        assertThatThrownBy(() -> Validator.validateName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("사다리 길이가 1이상, 10이하면 예외가 발생하지 않는다.")
    void validateLadderHeightSuccessTest() {
        assertThatCode(() -> Validator.validateLadderHeight(6))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "사다리 길이가 1미만, 10초과면 예외가 발생한다. 입력값 = {0}")
    @ValueSource(ints = {0, 11, -1})
    void validateLadderHeightFailureTest(int input) {
        assertThatThrownBy(() -> Validator.validateLadderHeight(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("중복된 값이 리스트에있으면 예외를 던진다")
    void validateDuplicationTest() {
        List<String> inputs = List.of("pobi", "pobi", "crong");
        assertThatThrownBy(() -> Validator.validateDuplication(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.DUPLICATED_INPUT.getMessage());
    }
}