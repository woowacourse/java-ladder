package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("플레이어가 2명 미만일 경우, 예외를 던진다")
    @Test
    void createTest_WhenCountOfPlayersUnder2_throwException() {
        List<String> names = List.of("pobi");

        assertThatThrownBy(() -> Players.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어는 2명 이상 존재해야 합니다.");
    }
}
