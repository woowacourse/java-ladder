package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("해당 인덱스의 플레이어를 알 수 있다")
    @Test
    void getTest() {
        List<String> names = List.of("pobi", "honux", "jk");
        Players players = Players.from(names);

        assertAll(
                () -> assertThat(players.get(0)).isEqualTo(new Player("pobi")),
                () -> assertThat(players.get(1)).isEqualTo(new Player("honux")),
                () -> assertThat(players.get(2)).isEqualTo(new Player("jk"))
        );
    }

    @DisplayName("요청한 인덱스가 범위를 벗어날 경우, 예외를 던진다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void getTest_WhenIndexIsOutOfRange_ThrowException(int index) {
        List<String> names = List.of("pobi", "honux", "jk");
        Players players = Players.from(names);

        assertThatThrownBy(() -> players.get(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("요청한 인덱스가 범위를 벗어났습니다.");
    }

    @DisplayName("총 플레이어 수를 알 수 있다")
    @Test
    void sizeTest() {
        List<String> names = List.of("pobi", "honux", "jk");
        Players players = Players.from(names);

        int actual = players.size();

        assertThat(actual).isEqualTo(names.size());
    }
}
