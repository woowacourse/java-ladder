package laddergame.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ParticipantNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"orange", "chanmin", "elephant"})
    @DisplayName("다섯 글자 초과한 이름이 입력되면, 예외가 발생한다.")
    void name_error_test(String errorName) {
        assertThatThrownBy(() -> new ParticipantName(errorName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "i", "JiWon", "우테코", "12345"})
    @DisplayName("한 글자에서 다섯 글자 범위의 이름이 입력되면, 예외가 발생하지 않는다.")
    void name_success_test(String validName) {
        assertDoesNotThrow(() -> new ParticipantName(validName));
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("공백이 입력되면, 예외가 발생한다.")
    void name_blank_test(String blankName) {
        assertThatThrownBy(() -> new ParticipantName(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
