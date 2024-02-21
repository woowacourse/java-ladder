package ladder.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersDtoTest {

    @Test
    @DisplayName("Dto로 변환한다.")
    void toDto() {
        List<String> playerNames = List.of("pobi", "honux", "crong", "jk");
        List<Player> players = playerNames.stream()
                .map(Player::new)
                .toList();

        PlayersDto playersDto = PlayersDto.from(new Players(players));

        assertThat(playersDto.playerNames()).isEqualTo(playerNames);
    }
}
