package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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

class PlayersTest {

    @Nested
    @DisplayName("참가자 수 범위 테스트")
    class PlayerNamesRangeTest {

        @ParameterizedTest
        @MethodSource("createPlayersSuccessWithRangeArguments")
        @DisplayName("참가자 수가 2 이상, 10 이하이면 정상적으로 생성된다")
        void createPlayerNamesSuccessWithRange(List<Player> players) {
            Assertions.assertThatCode(() -> new Players(players))
                    .doesNotThrowAnyException();
        }

        private static Stream<Arguments> createPlayersSuccessWithRangeArguments() {
            return Stream.of(
                    Arguments.arguments(List.of(new Player(new PlayerName("a"), 0),
                            new Player(new PlayerName("b"), 0))),

                    Arguments.arguments(List.of(new Player(new PlayerName("a"), 0),
                            new Player(new PlayerName("b"), 0), new Player(new PlayerName("c"), 0),
                            new Player(new PlayerName("d"), 0), new Player(new PlayerName("e"), 0),
                            new Player(new PlayerName("f"), 0), new Player(new PlayerName("g"), 0),
                            new Player(new PlayerName("h"), 0), new Player(new PlayerName("i"), 0),
                            new Player(new PlayerName("j"), 0))));
        }

        @ParameterizedTest
        @MethodSource("createPlayersFailByRangeArguments")
        @DisplayName("참가자 수가 2 미만, 10 초과이면 예외가 발생한다")
        void createPlayerNamesFailByRange(List<Player> players) {
            Assertions.assertThatThrownBy(() -> new Players(players))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Players.PLAYER_NAMES_RANGE);
        }

        private static Stream<Arguments> createPlayersFailByRangeArguments() {
            return Stream.of(
                    Arguments.arguments(List.of(new Player(new PlayerName("a"), 0))),

                    Arguments.arguments(List.of(new Player(new PlayerName("a"), 0),
                            new Player(new PlayerName("b"), 0), new Player(new PlayerName("c"), 0),
                            new Player(new PlayerName("d"), 0), new Player(new PlayerName("e"), 0),
                            new Player(new PlayerName("f"), 0), new Player(new PlayerName("g"), 0),
                            new Player(new PlayerName("h"), 0), new Player(new PlayerName("i"), 0),
                            new Player(new PlayerName("j"), 0), new Player(new PlayerName("k"), 0))));
        }
    }

    @Nested
    @DisplayName("참가자 이름 중복 테스트")
    class PlayerNamesDuplicationTest {

        @Test
        @DisplayName("참가자 이름에 중복이 없으면 정상적으로 생성된다")
        void createPlayerNamesSuccessWithDuplication() {
            // given
            List<Player> players = List.of(new Player(new PlayerName("a"), 0),
                    new Player(new PlayerName("b"), 0));

            // then
            Assertions.assertThatCode(() -> new Players(players))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("참가자 이름에 중복이 있으면 예외가 발생한다")
        void createPlayerNamesFailByDuplication() {
            // given
            List<Player> players = List.of(new Player(new PlayerName("a"), 0),
                    new Player(new PlayerName("a"), 0));

            // then
            Assertions.assertThatThrownBy(() -> new Players(players))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Players.PLAYER_NAMES_DUPLICATION);
        }
    }

    @Nested
    @DisplayName("Players 기능 테스트")
    class PlayersFunctionTest {
        Players players;

        @BeforeEach
        void initPlayers() {
            List<String> playerNames = List.of("kaki", "pobi");
            players = new Players(
                    IntStream.range(0, playerNames.size())
                            .mapToObj(i -> new Player(new PlayerName(playerNames.get(i)), i))
                            .collect(Collectors.toList())
            );
        }

        @Test
        @DisplayName("인덱스 번째의 플레이어가 해당 방향으로 이동한다")
        void moveToPlayerOfIndexTest() {
            // when
            players.moveToPlayerOfIndex(0, 1);
            players.moveToPlayerOfIndex(1, -1);

            // then
            assertAll(
                    () -> assertThat(players.getPositionOfIndex(0)).isEqualTo(1),
                    () -> assertThat(players.getPositionOfIndex(1)).isEqualTo(0)
            );
        }

        @Test
        @DisplayName("파라미터로 넘겨 받은 사람이름이 참가자이면 true, 아니면 false를 반환한다")
        void isParticipateTest() {
            // given
            String playerName1 = "solar";
            String playerName2 = "kaki";

            // when
            boolean participate1 = players.isParticipate(playerName1);
            boolean participate2 = players.isParticipate(playerName2);

            // then
            assertThat(participate1).isFalse();
            assertThat(participate2).isTrue();
        }
    }
}
