package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        List<String> names = List.of("아톰", "산초");

        Players players = new Players(names);
    }

    @DisplayName("사람들의 이름을 받아 사람 리스트로 변환한다.")
    @Test
    void mapToPlayer() {
        List<String> names = List.of("아톰", "산초");

        Players players = new Players(names);

        List<Player> result = players.getPlayers();

        assertThat(result)
                .containsExactly(new Player("아톰"), new Player("산초"));
    }
}
