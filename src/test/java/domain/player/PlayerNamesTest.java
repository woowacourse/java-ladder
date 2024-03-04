package domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerNamesTest {

    @Nested
    @DisplayName("참가자 수 범위 테스트")
    class PlayerNamesRangeTest {

        @ParameterizedTest
        @MethodSource("createPlayersSuccessWithRangeArguments")
        @DisplayName("참가자 수가 2 이상, 10 이하이면 정상적으로 생성된다")
        void createPlayerNamesSuccessWithRange(List<PlayerName> playerNames) {
            Assertions.assertThatCode(() -> new PlayerNames(playerNames))
                    .doesNotThrowAnyException();
        }

        private static Stream<Arguments> createPlayersSuccessWithRangeArguments() {
            return Stream.of(
                    Arguments.arguments(List.of(new PlayerName("a"), new PlayerName("b"))),

                    Arguments.arguments(List.of(new PlayerName("a"), new PlayerName("b"), new PlayerName("c"),
                            new PlayerName("d"), new PlayerName("e"), new PlayerName("f"), new PlayerName("g"),
                            new PlayerName("h"), new PlayerName("i"), new PlayerName("j")))
            );
        }

        @ParameterizedTest
        @MethodSource("createPlayersFailByRangeArguments")
        @DisplayName("참가자 수가 2 미만, 10 초과이면 예외가 발생한다")
        void createPlayerNamesFailByRange(List<PlayerName> playerNames) {
            Assertions.assertThatThrownBy(() -> new PlayerNames(playerNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(PlayerNames.PLAYER_NAMES_RANGE);
        }

        private static Stream<Arguments> createPlayersFailByRangeArguments() {
            return Stream.of(
                    Arguments.arguments(List.of(new PlayerName("a"))),

                    Arguments.arguments(List.of(new PlayerName("a"), new PlayerName("b"), new PlayerName("c"),
                            new PlayerName("d"), new PlayerName("e"), new PlayerName("f"), new PlayerName("g"),
                            new PlayerName("h"), new PlayerName("i"), new PlayerName("j"), new PlayerName("k")))
            );
        }
    }

    @Nested
    @DisplayName("참가자 이름 중복 테스트")
    class PlayerNamesDuplicationTest {

        @Test
        @DisplayName("참가자 이름에 중복이 없으면 정상적으로 생성된다")
        void createPlayerNamesSuccessWithDuplication() {
            // given
            List<PlayerName> playerNames = List.of(new PlayerName("a"), new PlayerName("b"));

            // then
            Assertions.assertThatCode(() -> new PlayerNames(playerNames))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("참가자 이름에 중복이 있으면 예외가 발생한다")
        void createPlayerNamesFailByDuplication() {
            // given
            List<PlayerName> playerNames = List.of(new PlayerName("a"), new PlayerName("a"));

            // then
            Assertions.assertThatThrownBy(() -> new PlayerNames(playerNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(PlayerNames.PLAYER_NAMES_DUPLICATION);
        }
    }

    @Nested
    @DisplayName("Players 기능 테스트")
    class PlayerNamesFunctionTest {
        PlayerNames playerNames;

        @BeforeEach
        void initPlayers() {
            List<String> names = List.of("kaki", "pobi");
            playerNames = new PlayerNames(IntStream.range(0, names.size())
                    .mapToObj(i -> new PlayerName(names.get(i)))
                    .collect(Collectors.toList())
            );
        }

        @Test
        @DisplayName("파라미터로 넘겨 받은 사람이름이 참가자이면 true, 아니면 false를 반환한다")
        void isParticipateTest() {
            // given
            String playerName1 = "solar";
            String playerName2 = "kaki";

            // when
            boolean participate1 = playerNames.isParticipate(playerName1);
            boolean participate2 = playerNames.isParticipate(playerName2);

            // then
            assertThat(participate1).isFalse();
            assertThat(participate2).isTrue();
        }
    }
}
