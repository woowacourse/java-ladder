package ladder.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {

    @DisplayName("가변 인자로 참여자들을 생성한다.")
    @Test
    void createPlayersWithVarargs() {
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

    @DisplayName("참여자가 두 명 미만이면 예외가 발생한다.")
    @Test
    void validateMinSize() {
        // when & then
        assertThatThrownBy(() -> new Players("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동일한 이름을 가진 참여자가 있으면 예외가 발생한다.")
    @Test
    void validateDuplicate() {
        // when & then
        assertThatThrownBy(() -> new Players("pobi", "pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자들을 생성한다.")
    @Test
    void createPlayers() {
        // when
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));

        // then
        assertThat(players.getPlayers()).containsExactly(
                new Player("pobi"),
                new Player("honux"),
                new Player("crong"),
                new Player("jk")
        );
    }

    @DisplayName("참여자의 인덱스를 찾는다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi, 0", "honux, 1", "crong, 2", "jk, 3"})
    void findIndexOfPlayer(String name, int actual) {
        // given
        Players players = new Players("pobi", "honux", "crong", "jk");

        // when
        Index expected = players.findIndexOfPlayer(new Player(name));

        // then
        assertThat(expected.getValue()).isEqualTo(actual);
    }

    @DisplayName("참여자가 아니라면 예외가 발생한다.")
    @Test
    void findIndexOfNonPlayer() {
        // given
        Players players = new Players("pobi", "honux", "crong", "jk");

        // when & then
        assertThatThrownBy(() -> players.findIndexOfPlayer(new Player("pobi1")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
