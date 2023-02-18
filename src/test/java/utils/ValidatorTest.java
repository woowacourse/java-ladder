package utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.constants.ErrorMessages;

class ValidatorTest {

    @Test
    @DisplayName("중복된 값이 있다면 예외를 던진다.")
    void should_throwException_when_duplicatedValues() {
        List<String> userNames = List.of("pobi", "pobi", "crong");
        assertThatThrownBy(() -> Validator.validateDuplication(userNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.DUPLICATED_INPUT.getMessage());
    }
}
