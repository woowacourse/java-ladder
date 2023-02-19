package laddergame.domain.participant;

import laddergame.domain.exception.BlankException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ParticipantNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "i", "JiWon", "우테코", "12345"})
    @DisplayName("한 글자에서 다섯 글자 범위의 이름이 입력되면, 예외가 발생하지 않는다.")
    void create_thenSuccess(final String validName) {
        assertThatCode(() -> ParticipantName.create(validName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"orange", "chanmin", "elephant"})
    @DisplayName("다섯 글자 초과한 이름이 입력되면, 예외가 발생한다.")
    void create_givenInvalidLengthName_thenFail(final String invalidName) {
        assertThatThrownBy(() -> ParticipantName.create(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참가자 이름은 5글자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "po bi", " po y", " p o "})
    @DisplayName("이름에 공백이 포함되면, 예외가 발생한다.")
    void create_givenIncludedBlankName_thenFail(final String invalidName) {
        assertThatThrownBy(() -> ParticipantName.create(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .isExactlyInstanceOf(BlankException.class)
                .hasMessage(String.format(BlankException.errorMessage, "참가자 이름은"));
    }
}
