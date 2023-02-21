package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import ladder.domain.generator.DirectionGenerator;
import ladder.domain.generator.LineGenerator;
import ladder.domain.generator.TestDirectionGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayersTest {

    private static Stream<Arguments> generateValidNameSize() {
        return Stream.of(
                Arguments.of(List.of("pobi", "crong"), new String[]{"pobi", "crong"}),
                Arguments.of(List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"),
                        new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"})
        );
    }

    private static Stream<Arguments> generateInvalidNameSize() {
        return Stream.of(
                Arguments.of(List.of("pobi")),
                Arguments.of(List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"))
        );
    }

    @ParameterizedTest(name = "입력: {0}, 출력: {1}")
    @MethodSource("generateValidNameSize")
    @DisplayName("플레이어는 2명 이상, 10명 이하만 가능하다.")
    void validPlayerSize(final List<String> names, final String[] expected) {
        final Players players = new Players(names);

        assertThat(players.getPlayerNames())
                .containsExactly(expected);
    }

    @ParameterizedTest(name = "입력: {0}")
    @MethodSource("generateInvalidNameSize")
    @DisplayName("플레이어는 2명 미만, 10명 초과인 경우 예외를 던진다.")
    void throwExceptionWhenInvalidPlayerSize(final List<String> names) {
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
        final ArrayList<Direction> directions = Lists.newArrayList(
                RIGHT, STAY, STAY, RIGHT, RIGHT, STAY, RIGHT, STAY, RIGHT, RIGHT);
        final DirectionGenerator directionGenerator = new TestDirectionGenerator(directions);
        final LineGenerator lineGenerator = new LineGenerator(directionGenerator);
        final Players players = new Players(List.of("pobi", "crong", "eddy"));
        final Height height = new Height(5);
        final Ladder ladder = new Ladder(lineGenerator, players, height);
        final String name = "eddy";
        final int expected = 1;

        // when
        Players resultPlayer = ladder.movePlayers(players);
        final int actual = resultPlayer.findPosition(name);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}

