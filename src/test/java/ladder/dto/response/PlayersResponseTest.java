package ladder.dto.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersResponseTest {

    @Test
    @DisplayName("Dto로 변환한다.")
    void toDto() {
        List<String> playerNames = List.of("pobi", "honux", "crong", "jk");

        Players players = Players.from(playerNames);
        PlayersResponse playersResponse = PlayersResponse.from(players);

        assertThat(playersResponse.playerResponses()).containsExactly(
                new PlayerResponse("pobi"),
                new PlayerResponse("honux"),
                new PlayerResponse("crong"),
                new PlayerResponse("jk")
        );
    }
}
