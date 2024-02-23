package ladder.dto.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersResponseTest {

    @Test
    @DisplayName("Dto로 변환한다.")
    void toDto() {
        List<String> playerNames = List.of("pobi", "honux", "crong", "jk");
        List<Player> players = playerNames.stream()
                .map(Player::new)
                .toList();

        PlayersResponse playersResponse = PlayersResponse.from(new Players(players));

        assertThat(playersResponse.playerResponses()).containsExactly(
                new PlayerResponse("pobi"),
                new PlayerResponse("honux"),
                new PlayerResponse("crong"),
                new PlayerResponse("jk")
        );
    }
}
