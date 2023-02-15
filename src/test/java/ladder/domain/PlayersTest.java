package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Stream;
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

        assertThat(players.getPlayers())
                .extracting(Player::getName)
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
}

