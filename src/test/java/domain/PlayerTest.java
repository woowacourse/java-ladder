package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    private static final String INVALID_NAME = "crrong";

    @DisplayName("사람의 이름이 5글자를 초과하면 예외를 발생시킨다.")
    @Test
    void invalidNameLength() {
        //given
        final String playerName = INVALID_NAME;
        //when & then
        Assertions.assertThatThrownBy(() -> new Player(playerName)).isInstanceOf(IllegalArgumentException.class);
    }
}