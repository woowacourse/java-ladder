package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {


    @DisplayName("이름이 중복되면 예외를 발생시킨다.")
    @Test
    void duplicatedName() {
        assertThatThrownBy(() -> new Players(List.of("zeze", "zeze")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 중복 될 수 없습니다.");
    }

    @DisplayName("이름을 입력하면 해당 플레이어를 반환한다.")
    @Test
    void testFind() {
        // given
        Players players = new Players(List.of("pobi", "zeze", "crong", "jk"));
        String player = "pobi";

        // when
        List<Player> result = players.find(player);

        // then
        Assertions.assertThat(result).extracting("name").containsExactly(player);
    }

    @DisplayName("all을 입력하면 전체 플레이어를 반환한다.")
    @Test
    void testFindAll() {
        // given
        Players players = new Players(List.of("pobi", "zeze", "crong", "jk"));

        // when
        List<Player> result = players.find("all");

        // then
        Assertions.assertThat(result).extracting("name")
                .containsExactly("pobi", "zeze", "crong", "jk");
    }
}
