package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class PlayerTest {

    @DisplayName("이름이 최대 글자를 초과할 경우 예외가 발생한다.")
    @Test
    void occurExceptionIfNameExceedsMaxLength() {
        assertThatThrownBy(() -> new Player("clover"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Player.ERROR_MAX_NAME_LENGTH);
    }

    @DisplayName("참여자 이름이 null이거나 공백인 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void occurExceptionIfPlayerNameIsNullOrBlank(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Player.ERROR_PLAYER_NAME_IS_NULL_OR_BLANK);
    }
}
