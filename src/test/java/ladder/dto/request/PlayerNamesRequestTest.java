package ladder.dto.request;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.player.Player;
import ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerNamesRequestTest {
    @DisplayName("객체로 변환한다.")
    @Test
    void testToPlayers() {
        PlayerNamesRequest playerNamesRequest = new PlayerNamesRequest("pobi,crong,honux");

        Players players = playerNamesRequest.toPlayers();

        assertThat(players.getPlayers()).containsExactly(
                new Player("pobi"),
                new Player("crong"),
                new Player("honux")
        );
    }
}
