package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PlayersTest {

    private final List<String> correctPlayerNames = List.of("pobi", "crong", "honux");

    @Test
    @DisplayName("모든 조건을 충족한 경우 Players 객체가 생성된다.")
    void playersInitiatorTest() {

        assertDoesNotThrow(() -> new Players(correctPlayerNames));
    }

    @Test
    @DisplayName("플레이어의 이름이 중복되는 경우, 예외가 발생한다")
    void validateDuplicatedName() {
        List<String> duplicatedPlayers = List.of("pobi", "pobi", "crong");

        assertThatThrownBy(() -> new Players(duplicatedPlayers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어의 수 반환 테스트")
    void getCountTest() {

        assertThat(new Players(correctPlayerNames).findNumberOfPlayers())
                .isEqualTo(correctPlayerNames.size());
    }

    @Test
    @DisplayName("플레이어 이름 리스트 반환 테스트")
    void getNameTest() {

        assertThat(new Players(correctPlayerNames).findNames())
                .isEqualTo(correctPlayerNames);
    }

    @Nested
    @DisplayName("플레이어 수 테스트")
    class PlayersInitiator {

        @Test
        @DisplayName("1명인 경우, 예외가 발생한다")
        void validateOnePlayer() {
            List<String> onePlayerName = List.of("pobi");

            assertThatThrownBy(() -> new Players(onePlayerName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("0명인 경우, 예외가 발생한다")
        void validateZeroPlayer() {
            List<String> zeroPlayerName = Collections.emptyList();

            assertThatThrownBy(() -> new Players(zeroPlayerName))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
