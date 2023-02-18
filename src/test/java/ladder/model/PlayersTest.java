package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class PlayersTest {

    @Test
    @DisplayName("플레이어가 2명 미만이면 예외처리 테스트")
    void invalidHeightTest() {
        List<Player> input = new ArrayList<>(List.of(new Player("이오")));
        Assertions.assertThatThrownBy(() -> new Players(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("플레이어가 2명 이상이면 통과하는 테스트")
    void validHeightTest() {
        List<Player> input = new ArrayList<>(List.of(new Player("이오"), new Player("이리내")));
        assertThatCode(() -> new Players(input)).doesNotThrowAnyException();
    }

}
