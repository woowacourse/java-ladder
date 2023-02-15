package ladder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    @DisplayName("여러 개의 이름을 입력받고 players를 생성한다")
    void shouldCreatePlayersWhenInputStrings () {
        //given
        List<String> names = new ArrayList<>(List.of("a", "ab", "abc"));
        //when
        //then
        assertDoesNotThrow(() -> new Players(names));
    }

    @Test
    @DisplayName("플레이어의 수를 반환한다")
    public void shouldReturnSizeWhenRequest () {
        //given
        List<String> names = new ArrayList<>(List.of("a", "ab", "abc"));
        //when
        Players players = new Players(names);
        //then
        assertThat(players.getSize()).isEqualTo(3);
    }
}
