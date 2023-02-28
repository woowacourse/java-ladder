package laddergame.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ParticipantNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "i", "JiWon", "우테코", "12345"})
    @DisplayName("이름의 길이가 한 글자에서 다섯 글자 사이이고 공백을 포함하지 않는다면, 예외가 발생하지 않는다.")
    void does_not_throw_exception_if_name_is_between_1_and_5(String validName) {
        assertDoesNotThrow(() -> ParticipantName.create(validName));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 빈값이라면, 예외가 발생한다.")
    void throws_exception_if_name_is_null_or_blank(String invalidName) {
        assertThatThrownBy(() -> ParticipantName.create(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이름을 입력하셔아 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi ", "po bi", " po y", " p o ", " pobi"})
    @DisplayName("이름에 공백이 포함되면, 예외가 발생한다.")
    void throws_exception_if_name_contains_blank(String invalidName) {
        assertThatThrownBy(() -> ParticipantName.create(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("[ERROR] 이름에 공백이 포함될 수 없습니다. 입력된 이름 : %s", invalidName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"orange", "chanmin", "elephant"})
    @DisplayName("이름이 다섯 글자를 초과하면, 예외가 발생한다.")
    void throws_exception_if_name_is_greater_than_5(String invalidName) {
        assertThatThrownBy(() -> ParticipantName.create(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("[ERROR] 이름은 5 글자를 초과할 수 없습니다. 입력된 이름 : %s", invalidName));
    }

    @Test
    @DisplayName("이름이 \"all\" 이라면, 예외가 발생한다.")
    void throws_exception_if_name_is_all() {
        String invalidName = "all";

        assertThatThrownBy(() -> ParticipantName.create(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("[ERROR] 이름은 \"%s\"일 수 없습니다.", invalidName));
    }
}
