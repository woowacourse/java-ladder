package player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

    @Test
    @DisplayName("플레이어들의 이름으로 올바르게 생성한다.")
    void validCreationTest() {
        assertDoesNotThrow(() -> new Players(List.of("aru", "pobi", "woowa")));
    }

    @Test
    @DisplayName("플레이어들의 이름을 올바르게 가져온다.")
    void getNamesTest() {
        // given
        Players players = new Players(List.of("aru", "pobi", "woowa"));
        // when
        List<String> actual = players.getNames();
        // then
        assertThat(actual).containsExactly("aru", "pobi", "woowa");
    }

    @ParameterizedTest
    @ValueSource(strings = {"one", "one,two,three,four,five,six,seven,eight,nine,ten,elevn"})
    @DisplayName("플레이어 수가 범위를 벗어나면 예외를 발생한다.")
    void invalidSizeTest(String names) {
        // given
        List<String> playerNames = List.of(names.split(","));
        // when, then
        assertThatThrownBy(() -> new Players(playerNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
