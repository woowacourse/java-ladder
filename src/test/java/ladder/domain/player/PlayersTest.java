package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PlayersTest {

    private final List<String> correctPlayerNames = List.of("pobi", "crong", "honux");

    private static List<Player> createPlayersByNames(List<String> playerNames) {
        return playerNames.stream()
                .map((name) -> new Player(new Name(name)))
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("모든 조건을 충족한 경우 Players 객체가 생성된다.")
    void playersInitiatorTest() {
        assertDoesNotThrow(() -> Players.create(correctPlayerNames));
    }

    @Test
    @DisplayName("플레이어의 이름이 중복되는 경우, 예외가 발생한다")
    void validateDuplicatedName() {
        List<String> playerNames = List.of("pobi", "pobi", "crong");

        assertThatThrownBy(() -> Players.create(playerNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("플레이어 수 테스트")
    class PlayersInitiator {

        @Test
        @DisplayName("1명인 경우, 예외가 발생한다")
        void validateOnePlayer() {
            List<String> playerNames = List.of("pobi");

            assertThatThrownBy(() -> Players.create(playerNames))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("0명인 경우, 예외가 발생한다")
        void validateZeroPlayer() {
            List<String> playerNames = Collections.emptyList();

            assertThatThrownBy(() -> Players.create(playerNames))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("플레이어의 수 반환 테스트")
    void getCountTest() {
        assertThat(Players.create(correctPlayerNames).count()).isEqualTo(correctPlayerNames.size());
    }

    @Test
    @DisplayName("플레이어 이름 리스트 반환 테스트")
    void getNameTest() {
        assertThat(Players.create(correctPlayerNames).getNames()).isEqualTo(correctPlayerNames);
    }

    @Test
    @DisplayName("타겟 플레이어 생성 테스트")
    void createTargetPlayers() {
        Players createPlayers = Players.create(correctPlayerNames);

        Players targetPlayers = createPlayers.createTargetPlayers(List.of("crong", "honux"));

        assertThat(targetPlayers.getPlayers().get(0)).isEqualTo(new Player(new Name("crong")));
        assertThat(targetPlayers.getPlayers().get(1)).isEqualTo(new Player(new Name("honux")));
    }

    @Test
    @DisplayName("타겟 플레이어 생성 시, 중복 이름 예외 테스트")
    void createTargetDuplicateExceptionPlayers() {
        Players createPlayers = Players.create(correctPlayerNames);

        assertThatThrownBy(()->createPlayers.createTargetPlayers(List.of("crong", "crong")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("타겟 플레이어 생성 시, 없는 이름 예외 테스트")
    void createTargetDoesNotExistExceptionPlayers() {
        Players createPlayers = Players.create(correctPlayerNames);

        assertThatThrownBy(()->createPlayers.createTargetPlayers(List.of("crong", "aaaa")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
