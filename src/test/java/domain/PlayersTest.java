package domain;

import static java.util.Collections.nCopies;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PlayersTest {

    static Stream<Arguments> createSuccessArguments() {
        return Stream.of(
                Arguments.arguments(
                        List.of("pobi", "tommy"),
                        List.of(nCopies(10, "pobi"))
                ));
    }

    static Stream<Arguments> createFailArguments() {
        return Stream.of(
                Arguments.arguments(
                        List.of("pobi"),
                        List.of(nCopies(10, "pobi"))
                ));
    }

    @DisplayName("2명 이상 10명 이하인 경우 예외가 발생하지않는다,")
    @ParameterizedTest
    @MethodSource("createSuccessArguments")
    public void createSuccess(List<String> names) {
        assertThatCode(() -> new Players(names))
                .doesNotThrowAnyException();
    }

    @DisplayName("2명 미만, 10명 초과하면 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("createFailArguments")
    public void createFail(List<String> names) {
        assertThatCode(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("2명 이상, 10명 이하인 인원만 입력해주세요. 입력한 인원 : %d", names.size()));
    }

    @DisplayName("플레이어의 이름으로 인덱스를 반환한다")
    @Test
    public void getPositionOf() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));

        assertAll(
                () -> assertThat(players.getPositionOf("pobi")).isEqualTo(0),
                () -> assertThat(players.getPositionOf("honux")).isEqualTo(1),
                () -> assertThat(players.getPositionOf("crong")).isEqualTo(2),
                () -> assertThat(players.getPositionOf("jk")).isEqualTo(3)
        );
    }
}
