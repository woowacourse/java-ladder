package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ExceptionMessages;

class NameTest {

    @DisplayName("참가자 이름이 1글자 미만, 5글자를 초과하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"crrong", ""})
    void overMaximumNameLength(String name) {
        //given
        final String playerName = name;
        //when & then
        Assertions.assertThatThrownBy(() -> new Name(playerName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INVALID_NAME_LENGTH);
    }

}
