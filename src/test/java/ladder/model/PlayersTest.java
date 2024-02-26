package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class PlayersTest {
    @Test
    @DisplayName("중복된 이름이 존재하는 경우 예외가 발생한다.")
    void duplicatedNamesTest() {
        List<String> playerNames = List.of("abc", "test", "abc");

        assertThatThrownBy(() -> Players.from(playerNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("영숫자로 구성된 5자리 이하의 이름은 유효한 이름이다.")
    void createNamesTest() {
        List<String> playerNames = List.of("abc", "def", "123");

        assertThatCode(() -> Players.from(playerNames))
                .doesNotThrowAnyException();
    }
}
