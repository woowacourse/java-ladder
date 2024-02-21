package ladder.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersDtoTest {

    @Test
    @DisplayName("Dto로 변환한다.")
    void toDto() {
        List<String> playerNames = List.of("pobi", "honux", "crong", "jk");
        Players players = new Players(playerNames);
        PlayersDto playersDto = PlayersDto.from(players);

        assertThat(playerNames).isEqualTo(playersDto.playerNames());
    }
}
