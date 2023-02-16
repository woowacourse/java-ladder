package laddergame.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static laddergame.domain.message.ErrorMessage.INVALID_NAME_BLANK;
import static laddergame.domain.message.ErrorMessage.INVALID_NANE_LENGTH;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ParticipantNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"orange", "chanmin", "elephant"})
    @DisplayName("다섯 글자 초과한 이름이 입력되면, 예외가 발생한다.")
    void name_error_test(String errorName) {
        assertThatThrownBy(() -> ParticipantName.create(errorName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NANE_LENGTH.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "i", "JiWon", "우테코", "12345"})
    @DisplayName("한 글자에서 다섯 글자 범위의 이름이 입력되면, 예외가 발생하지 않는다.")
    void name_success_test(String validName) {
        assertDoesNotThrow(() -> ParticipantName.create(validName));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "pobi ", "po bi", " po y", " p o ", " pobi"})
    @DisplayName("이름에 공백이 포함되면, 예외가 발생한다.")
    void name_with_blank_error_test(String blankName) {
        assertThatThrownBy(() -> ParticipantName.create(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_BLANK.getMessage());
    }
}
