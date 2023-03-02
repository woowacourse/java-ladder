package ladder.domain.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNameTest {

    @Test
    @DisplayName("Name 객체 equals 테스트")
    void equalsTest() {
        final String nameValue = "pobi";

        final PlayerName other = new PlayerName(nameValue);
        assertThat(new PlayerName(nameValue)).isEqualTo(other);
    }

    @Nested
    @DisplayName("플레이어 이름 생성할 때, ")
    class PlayerInitiatorTest {

        @ParameterizedTest(name = "inputName = {0}")
        @ValueSource(strings = {"가", "가나", "가나다라마"})
        @DisplayName("플레이어의 이름이 1자 이상 5자 이하인 경우, 정상 생성된다.")
        void createCorrectPlayerNameTest(final String name) {
            Assertions.assertDoesNotThrow(() -> new PlayerName(name));
        }

        @ParameterizedTest(name = "inputName = {0}")
        @ValueSource(strings = {"", "    ", "가나다라마바", "가나다라마바사아자차"})
        @DisplayName("플레이어의 이름이 공백, 빈문자열이거나 5자 초과하면 예외가 발생한다.")
        void createPlayerNameLengthExceptionTest(final String name) {
            assertThatThrownBy(() -> new PlayerName(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("플레이어의 이름은 5자 이하여야 합니다.");
        }

        @Test
        @DisplayName("플레이어의 이름이 명령어에 해당하는 경우 예외가 발생한다.")
        void createPlayerNameCommandExceptionTest() {
            final String commandAll = "all";

            assertThatThrownBy(() -> new PlayerName(commandAll))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("all은 플레이어의 이름으로 불가능 합니다.");
        }

    }
}
