package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class InputValidatorTest {

    @DisplayName("참여자 이름이 null이거나 공백이면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void occurExceptionIfPlayerNameIsNullOrBlank(String name) {
        assertThatThrownBy(() -> InputValidator.validatePlayerName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.ERROR_PLAYER_NAME_IS_NULL_OR_BLANK);
    }

    @DisplayName("참여자 이름이 게임 커맨드에 사용되는 키워드와 같으면 예외가 발생한다.")
    @Test
    void occurExceptionIfPlayerNameIsCommand() {
        // given
        String name = "all";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateIsNotCommand(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(name + InputValidator.ERROR_IS_IMPOSSIBLE_NAME);
    }
}
