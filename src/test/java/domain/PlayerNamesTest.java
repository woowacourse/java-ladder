package domain;

import common.exception.message.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class PlayerNamesTest {

    @Nested
    @DisplayName("참가자 수 범위 테스트")
    class PlayerNamesRangeTest {

        @ParameterizedTest
        @MethodSource("createPlayerNamesSuccessWithRangeArguments")
        @DisplayName("참가자 수가 2 이상, 10 이하이면 정상적으로 생성된다")
        void createPlayerNamesSuccessWithRange(List<PlayerName> playerNames) {
            Assertions.assertThatCode(() -> new PlayerNames(playerNames))
                    .doesNotThrowAnyException();
        }

        private static Stream<Arguments> createPlayerNamesSuccessWithRangeArguments() {
            return Stream.of(
                    Arguments.arguments(List.of(new PlayerName("a"), new PlayerName("b"))),
                    Arguments.arguments(List.of(new PlayerName("a"), new PlayerName("b"),
                            new PlayerName("c"), new PlayerName("d"), new PlayerName("e"),
                            new PlayerName("f"), new PlayerName("g"), new PlayerName("h"),
                            new PlayerName("i"), new PlayerName("j"))));
        }

        @ParameterizedTest
        @MethodSource("createPlayerNamesFailByRangeArguments")
        @DisplayName("참가자 수가 2 미만, 10 초과이면 예외가 발생한다")
        void createPlayerNamesFailByRange(List<PlayerName> playerNames) {
            Assertions.assertThatThrownBy(() -> new PlayerNames(playerNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.PLAYER_NAMES_RANGE_ERROR);
        }

        private static Stream<Arguments> createPlayerNamesFailByRangeArguments() {
            return Stream.of(
                    Arguments.arguments(List.of(new PlayerName("a")),
                            Arguments.arguments(List.of(new PlayerName("a"), new PlayerName("b"),
                                    new PlayerName("c"), new PlayerName("d"), new PlayerName("e"),
                                    new PlayerName("f"), new PlayerName("g"), new PlayerName("h"),
                                    new PlayerName("i"), new PlayerName("j"), new PlayerName("k")))));
        }
    }

}