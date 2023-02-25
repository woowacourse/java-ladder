package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.text.MessageFormat;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

    @ParameterizedTest(name = "입력: {0}, 출력: {1}")
    @ValueSource(strings = {"pobi,crong", "A,B,C,D,E,F,G,H,I,J"})
    @DisplayName("플레이어는 2명 이상, 10명 이하만 가능하다.")
    void validPlayerSize(final String nameRawData) {
        final List<String> names = List.of(nameRawData.split(","));
        final String[] expected = nameRawData.split(",");

        final Players players = new Players(names);

        assertThat(players.getPlayerNames())
                .containsExactly(expected);
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"pobi", "A,B,C,D,E,F,G,H,I,J,K"})
    @DisplayName("플레이어는 2명 미만, 10명 초과인 경우 예외를 던진다.")
    void throwExceptionWhenInvalidPlayerSize(final String namesRawData) {
        final List<String> names = List.of(namesRawData.split(","));

        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageFormat.format(
                        "플레이어는 2명 이상, 10명 이하만 가능합니다. 현재 입력한 플레이어 수는 {0}명 입니다.", names.size()
                ));
    }

    @Test
    @DisplayName("플레이어의 이름에 중복이 있으면 예외를 던진다.")
    void throwExceptionWhenDuplicatePlayerName() {
        final List<String> names = List.of("pobi", "crong", "eddy", "crong");

        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 게임이 끝난 후, 특정 플레이어가 어디 위치에 있는지 알 수 있다.")
    void findPlayerPositionAfterLadderGame() {
        // given
        final Players players = new Players(List.of("pobi", "crong", "eddy"), List.of(2, 0, 1));
        final String name = "eddy";
        final int expected = 1;

        // when
        final int actual = players.findPositionByName(name);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}

