package player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
