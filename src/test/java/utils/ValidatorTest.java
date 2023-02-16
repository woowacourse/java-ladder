package utils;

import domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Validator;
import utils.constants.ErrorMessages;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @ParameterizedTest(name = "이름이 1글자 이상 5글자 이하면 예외를 던지지 않는다. 입력값 = {0}")
    @ValueSource(strings = {"pobi", "honux", "j"})
    void should_notThrowException_when_nameLengthIsValid(String name) {
        Assertions.assertThatCode(() -> Validator.validateName(name))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "이름이 1글자 미만 5글자 초과면 예외를 던진다. 입력값 = {0}")
    @ValueSource(strings = {"", "honuxx"})
    void should_throwException_when_nameLengthIsInvalid(String name) {
        Assertions.assertThatThrownBy(() -> Validator.validateName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest(name = "사다리 높이가 1 이상, 10 이하면 예외가 던지지 않는다. 입력값 = {0}")
    @ValueSource(ints = {1, 3, 10})
    void should_notThrowException_when_ladderHeightIsValid(int ladderHeight) {
        assertThatCode(() -> Validator.validateLadderHeight(ladderHeight))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "사다리 높이가 1 미만, 10 초과면 예외를 던진다. 입력값 = {0}")
    @ValueSource(ints = {0, 11, -1})
    void should_throwException_when_ladderHeightIsInvalid(int ladderHeight) {
        assertThatThrownBy(() -> Validator.validateLadderHeight(ladderHeight))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("중복된 값이 있다면 예외를 던진다.")
    void should_throwException_when_duplicatedValues() {
        List<String> userNames = List.of("pobi", "pobi", "crong");
        assertThatThrownBy(() -> Validator.validateDuplication(userNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.DUPLICATED_INPUT.getMessage());
    }
}
