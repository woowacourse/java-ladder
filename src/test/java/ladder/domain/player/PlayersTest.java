package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThatCode;
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

    @DisplayName("플레이어가 중복될 경우, 예외를 던진다")
    @Test
    void createTest_WhenNameIsOverlapped_throwException() {
        List<String> names = List.of("pobi", "pobi");

        assertThatThrownBy(() -> Players.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어가 중복 되어서는 안됩니다.");
    }

    @DisplayName("곂치지 않는 2명 이상의 플레이어가 있을 경우, 정상적으로 생성된다")
    @Test
    void createTest() {
        List<String> names = List.of("pobi", "honux");

        assertThatCode(() -> Players.from(names))
                .doesNotThrowAnyException();
    }
}
