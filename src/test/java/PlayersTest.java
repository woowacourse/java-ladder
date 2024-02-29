import domain.Player;
import domain.Players;
import domain.Position;
import message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static message.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    @DisplayName("플레이어들 객체가 정상적으로 생성된다.")
    @Test
    void createPlayers() {
        Player player1 = new Player("dodo", new Position(0));
        Player player2 = new Player("capy", new Position(0));
        Players players = new Players(List.of(player1, player2));

        assertThat(players.getPlayers().get(0)).isEqualTo(player1);
        assertThat(players.getPlayers().get(1)).isEqualTo(player2);
    }

    @DisplayName("플레이어가 1명 이하인 경우 예외를 발생한다.")
    @Test
    void createPlayersWithInvalidSize() {
        Player player = new Player("dodo",new Position(0));
        assertThatThrownBy(() -> new Players(List.of(player)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PLAYER_COUNT_EXCEPTION.getMessage());
    }
}
