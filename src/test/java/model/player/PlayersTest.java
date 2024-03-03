package model.player;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayersTest {

    @DisplayName("참여자 수가 2명 미만이면 예외 발생")
    @ParameterizedTest
    @MethodSource("provideInvalidPlayerNames")
    void testInvalidSizeOfPlayers(List<String> names) {
        assertThatThrownBy(() -> Players.of(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidPlayerNames() {
        return Stream.of(
            Arguments.of(List.of("pobi")),
            Arguments.of(List.of())
        );
    }

    @DisplayName("참여자 수가 2명 이상이면 객체 생성 성공")
    @ParameterizedTest
    @MethodSource("provideValidPlayerNames")
    void testValidSizeOfPlayers(List<String> names) {
        assertThatCode(() -> Players.of(names))
            .doesNotThrowAnyException();
    }

    private static Stream<Arguments> provideValidPlayerNames() {
        return Stream.of(
            Arguments.of(List.of("pobi", "dora")),
            Arguments.of(List.of("pobi", "doraa", "jojo"))
        );
    }

    @DisplayName("참여자 이름이 중복되면 예외 발생")
    @ParameterizedTest
    @MethodSource("provideDuplicatedPlayerNames")
    void testInvalidPlayerNamesUnique(List<String> names) {
        assertThatThrownBy(() -> Players.of(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideDuplicatedPlayerNames() {
        return Stream.of(
            Arguments.of(List.of("pobi", "pobi")),
            Arguments.of(List.of("dora", "jojo", "dora"))
        );
    }

    @DisplayName("참여자 이름이 중복되지 않으면 객체 생성 성공")
    @ParameterizedTest
    @MethodSource("provideUniquePlayerNames")
    void testValidPlayerNamesUnique(List<String> names) {
        assertThatCode(() -> Players.of(names))
            .doesNotThrowAnyException();
    }

    private static Stream<Arguments> provideUniquePlayerNames() {
        return Stream.of(
            Arguments.of(List.of("pobi", "dora")),
            Arguments.of(List.of("pobi", "doraa", "jojo"))
        );
    }
}
