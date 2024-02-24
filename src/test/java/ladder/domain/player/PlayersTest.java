package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayersTest {
    private final Players players = Players.from(List.of("pobi", "honux", "crong", "jk"));

    @Test
    @DisplayName("참가자들을 생성한다.")
    void testConstruct() {
        assertThat(players.getPlayers()).containsExactly(
                new Player("pobi"),
                new Player("honux"),
                new Player("crong"),
                new Player("jk")
        );
    }

    @Test
    @DisplayName("참가자들의 수를 셀 수 있다.")
    void countPlayers() {
        int actual = players.size();
        assertThat(actual).isEqualTo(4);
    }

    @Nested
    @DisplayName("참가자들의 수가")
    class InvalidPlayerNames {

        @Test
        @DisplayName("최소 범위보다 작을 경우 예외를 발생한다.")
        void testLessThanMinimumSize() {
            List<String> playerNames = List.of("pobi");

            assertThatThrownBy(() -> Players.from(playerNames))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("최대 범위보다 클 경우 예외를 발생한다.")
        void testGreaterThanMaximumSize() {
            List<String> playerNames = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");

            assertThatThrownBy(() -> Players.from(playerNames))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("참가자들의 이름이 중복된 경우 예외를 발생한다.")
        void testDuplicatedName() {
            List<String> playerNames = List.of("pobi", "pobi", "crong", "jk");

            assertThatThrownBy(() -> Players.from(playerNames))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
