package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {
    @Test
    @DisplayName("중복된 이름이 존재하는 경우 예외가 발생한다.")
    void duplicatedNamesTest() {
        List<String> playerNames = List.of("abc", "test", "abc");

        assertThatThrownBy(() -> Players.from(playerNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("해당하는 플레이어가 없으면 예외가 발생한다.")
    void playerExistTest() {
        Players players = Players.from(List.of("hi", "my", "name"));
        Player player = new Player("is");

        assertThatThrownBy(() -> players.isContainsOrSameAsAll(player))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당하는 이름의 플레이어가 없습니다.");
    }

    @Test
    @DisplayName("이름 입력값이 all인 경우는 예외가 발생하지 않는다.")
    void playerNameEqualsAllTest() {
        Players players = Players.from(List.of("hi", "my", "name"));
        Player player = new Player("all");

        assertThatCode(() -> players.isContainsOrSameAsAll(player))
                .doesNotThrowAnyException();
    }
}
