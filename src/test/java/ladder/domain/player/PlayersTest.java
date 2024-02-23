package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayersTest {
    private final Players players = new Players(List.of(
            new Player("pobi"),
            new Player("honux"),
            new Player("crong"),
            new Player("jk")
    ));

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
        int actual = players.getSize();
        assertThat(actual).isEqualTo(4);
    }

    @Nested
    @DisplayName("참가자들의 수가")
    class InvalidPlayerNames {

        @Test
        @DisplayName("최소 범위보다 작을 경우 예외를 발생한다.")
        void testLessThanMinimumSize() {
            List<Player> players = List.of(new Player("pobi"));

            assertThatThrownBy(() -> new Players(players))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("최대 범위보다 클 경우 예외를 발생한다.")
        void testGreaterThanMaximumSize() {
            List<Player> players = List.of(
                    new Player("1"), new Player("2"), new Player("3"), new Player("4"),
                    new Player("5"), new Player("6"), new Player("7"), new Player("8"),
                    new Player("9"), new Player("10"), new Player("11")
            );

            assertThatThrownBy(() -> new Players(players))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("참가자들의 이름이 중복된 경우 예외를 발생한다.")
        void testDuplicatedName() {
            List<Player> players = List.of(new Player("pobi"), new Player("pobi"),
                    new Player("honux"));

            assertThatThrownBy(() -> new Players(players))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
