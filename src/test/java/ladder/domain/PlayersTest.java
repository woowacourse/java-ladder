package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PlayersTest {

    private static List<Player> createPlayersByNames(List<String> playerNames) {
        return playerNames.stream()
                .map((name) -> new Player(new Name(name)))
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("모든 조건을 충족한 경우 Players 객체가 생성된다.")
    void playersInitiatorTest() {
        List<String> playerNames = List.of("pobi", "crong", "honux");

        List<Player> players = createPlayersByNames(playerNames);

        assertDoesNotThrow(Players::new);
    }

    @Test
    @DisplayName("플레이어의 이름이 중복되는 경우, 예외가 발생한다")
    void validateDuplicatedName() {
        List<String> playerNames = List.of("pobi", "pobi", "crong");

        List<Player> duplicatedPlayers = createPlayersByNames(playerNames);

        assertThatThrownBy(() -> new Players(duplicatedPlayers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("모든 조건을 충족한 경우 Players 객체가 생성된다.")
    void playersInitiatorTest() {
        List<String> playerNames = List.of("pobi", "crong", "honux");

        List<Player> players = createPlayersByNames(playerNames);

        assertDoesNotThrow(Players::new);
    }

    @Nested
    @DisplayName("Players")
    class PlayersInitiator {

        @Test
        @DisplayName("플레이어의 수가 1명인 경우, 예외가 발생한다")
        void validateCountOfPlayer() {
            List<String> playerNames = List.of("pobi");

            List<Player> onePlayer = createPlayersByNames(playerNames);

            assertThatThrownBy(() -> new Players(onePlayer))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("플레이어의 수가 0명인 경우, 예외가 발생한다")
        void validateCountOfPlayer() {
            List<String> playerNames = Collections.EMPTY_LIST;

            List<Player> zeroPlayer = createPlayersByNames(playerNames);

            assertThatThrownBy(() -> new Players(zeroPlayer))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
