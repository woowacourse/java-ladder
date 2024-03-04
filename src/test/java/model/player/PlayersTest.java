package model.player;

import java.util.List;
import model.players.Player;
import model.players.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {
    @Test
    @DisplayName("정상적으로 참여 인원 객체를 생성한다. ")
    void createSuccess() {
        List<String> players = List.of("pobi", "anna");
        Assertions.assertThatCode(() -> new Players(players))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("참여 인원이 2명 미만이어서 오류가 발생한다.")
    void invalidPlayers() {
        List<String> players = List.of("pobi");
        Assertions.assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 이름의 참여 인원인 경우 오류를 반환한다.")
    void duplicatedPlayersName() {
        List<String> players = List.of("pobi", "pobi", "anna");
        Assertions.assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("이름을 통해 Player 객체를 조회한다.")
    void findByName() {
        Players players = new Players(List.of("pobi", "anna", "ready"));
        Player player = players.findByName("pobi");
        Assertions.assertThat(player).isEqualTo(new Player("pobi"));
    }
}
