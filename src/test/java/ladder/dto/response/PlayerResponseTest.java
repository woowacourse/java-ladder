package ladder.dto.response;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerResponseTest {

    @Test
    @DisplayName("dto로 변환한다.")
    void toDto() {
        Player player = new Player("pobi");
        PlayerResponse playerResponse = PlayerResponse.from(player);

        assertThat(playerResponse.name()).isEqualTo("pobi");
    }
}
