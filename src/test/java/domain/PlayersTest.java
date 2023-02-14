package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    @DisplayName("사용자 이름이 입력되면 콤마(,) 로 구분한다.")
    void create_usingComma() {
        // given
        String input = "glen,doggy";
        // when
        Players players = new Players(input);
        // then
        assertThat(players.getPlayers()).hasSize(2);
    }
}
