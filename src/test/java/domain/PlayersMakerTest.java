package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Player;
import domain.Players;
import domain.PlayersMaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersMakerTest {

    @Test
    @DisplayName("입력받은 플레이어 이름 문자열로 Players 객체 생성 확인")
    void makePlayers() {
        Players players = PlayersMaker.makePlayers("roy,soy,coy");
        Assertions.assertAll(
                () -> assertThat(players.getPlayers().get(0)).isEqualTo(new Player("roy")),
                () -> assertThat(players.getPlayers().get(1)).isEqualTo(new Player("soy")),
                () -> assertThat(players.getPlayers().get(2)).isEqualTo(new Player("coy"))
        );
    }
}
