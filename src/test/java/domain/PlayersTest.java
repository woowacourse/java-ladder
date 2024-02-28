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
    void createPlayerNames() {
        PlayerName player1 = new PlayerName("dodo");
        PlayerName player2 = new PlayerName("capy");
        assertThatCode(() -> new Players(List.of(player1, player2)))
                .doesNotThrowAnyException();
    }

    @DisplayName("플레이어가 1명 이하인 경우 예외를 발생한다.")
    @Test
    void createPlayerNamesWithInvalidSize() {
        PlayerName player = new PlayerName("dodo");
        assertThatThrownBy(() -> new Players(List.of(player)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 이름이 중복된 경우 예외를 발생한다.")
    @Test
    void createPlayerNamesWithOverlap() {
        assertThatThrownBy(() -> new Players(List.of(new PlayerName("dodo"), new PlayerName("dodo"), new PlayerName("capy"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 몇번째 순서인지 반환합니다.(0부터)")
    @Test
    void findPlayerNameOrderNumber() {
        PlayerName player1 = new PlayerName("dodo");
        PlayerName player2 = new PlayerName("capy");
        Players players = new Players(List.of(player1, player2));

        assertThat(players.getPlayerNameOrderNumber("dodo")).isEqualTo(0);
    }
}
