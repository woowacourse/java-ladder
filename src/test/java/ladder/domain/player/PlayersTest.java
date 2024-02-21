package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    @DisplayName("참가자들을 생성한다.")
    void testConstruct() {
        List<String> playerNames = List.of("pobi", "honux", "crong", "jk");
        Players players = new Players(playerNames);

        assertThat(players.getPlayers()).extracting("name")
                .containsExactly("pobi", "honux", "crong", "jk");
    }

    @Nested
    @DisplayName("참가자들이 유효햐지 않을 경우 예외가 발생한다.")
    class InvalidPlayerNames {

        @Test
        @DisplayName("참가자들의 수가 범위를 벗어난 경우 예외를 발생한다.")
        void testLessThanMinimumSize() {
            assertThatThrownBy(() -> new Players(List.of("pobi")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("참가자들의 수가 범위를 벗어난 경우 예외를 발생한다.")
        void testGreaterThanMaximumSize() {
            List<String> playerNames = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");

            assertThatThrownBy(() -> new Players(playerNames))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("참가자들의 이름이 중복된 경우 예외를 발생한다.")
        void testDuplicatedName() {
            assertThatThrownBy(() -> new Players(List.of("pobi", "pobi", "honux")))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
