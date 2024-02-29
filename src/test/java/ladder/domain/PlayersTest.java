package ladder.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {

    @DisplayName("참여자가 두 명 미만이면 예외가 발생한다.")
    @Test
    void validateMinSize() {
        // when & then
        assertThatThrownBy(() -> new Players(List.of("pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동일한 이름을 가진 참여자가 있으면 예외가 발생한다.")
    @Test
    void validateDuplicate() {
        // when & then
        assertThatThrownBy(() -> new Players(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자들을 생성한다.")
    @Test
    void createPlayers() {
        // when
        Players players = new Players("pobi", "honux", "crong", "jk");

        // then
        assertThat(players.getPlayers()).containsExactly(
                new Player("pobi"),
                new Player("honux"),
                new Player("crong"),
                new Player("jk")
        );
    }
}
