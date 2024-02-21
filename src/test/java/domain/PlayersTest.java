package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Players players = new Players("아톰,산초");
    }

    @DisplayName("사람들의 이름을 받아 사람 리스트로 변환한다.")
    @Test
    void parsePersonName() {
        Players players = new Players("아톰,산초");

        List<Player> result = players.getPlayers();

        Assertions.assertThat(result)
                .containsExactly(new Player("아톰"), new Player("산초"));
    }
}
