package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("참가자 이름이 5글자를 초과하면 예외를 발생시킨다.")
    @Test
    void overMaximumNameLength() {
        //given
        final String playerName = "crrong";
        //when & then
        Assertions.assertThatThrownBy(() -> new Player(playerName)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자 이름이 1글자 미만이면 예외를 발생시킨다.")
    @Test
    void underMinimumNameLength() {
        //given
        final String playerName = "";
        //when & then
        Assertions.assertThatThrownBy(() -> new Player(playerName)).isInstanceOf(IllegalArgumentException.class);
    }
}