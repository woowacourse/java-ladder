import domain.Player;
import domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    @DisplayName("플레이어들 객체가 정상적으로 생성된다.")
    @Test
    void createPlayers() {
        Player player1 = new Player("dodo");
        Player player2 = new Player("capy");
        assertThatCode(() -> new Players(List.of(player1, player2)))
                .doesNotThrowAnyException();
    }

    @DisplayName("플레이어가 1명 이하인 경우 예외를 발생한다.")
    @Test
    void createPlayersWithInvalidSize() {
        Player player = new Player("dodo");
        assertThatThrownBy(() -> new Players(List.of(player)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
