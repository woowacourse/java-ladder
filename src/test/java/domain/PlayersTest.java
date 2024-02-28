package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("플레이어 이름이 중복된 경우 예외를 발생한다.")
    @Test
    void createPlayersWithOverlap() {
        assertThatThrownBy(() -> new Players(List.of(new Player("dodo"), new Player("dodo"), new Player("capy"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 몇번째 순서인지 반환합니다.(0부터)")
    @Test
    void findPlayerOrderNumber() {
        Player player1 = new Player("dodo");
        Player player2 = new Player("capy");
        Players players = new Players(List.of(player1, player2));

        assertThat(players.getPlayerOrderNumber("dodo")).isEqualTo(0);
    }
}
