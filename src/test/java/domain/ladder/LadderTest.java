package domain.ladder;

import common.exception.model.ValidationException;
import domain.bridge.strategy.BridgeGeneratorStub;
import domain.player.PlayerName;
import domain.player.PlayerNames;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    @Nested
    @DisplayName("사다리 높이, 사람 수 테스트")
    class LadderHeightTest {
        @ParameterizedTest
        @MethodSource("createLadderSuccessWithHeightAndPointCountArguments")
        @DisplayName("사다리 높이가 2 이상, 10 이하이며 사람의 수가 2 이상, 10 이하이면 정상적으로 생성된다")
        void createLadderSuccessWithHeightAndPointCount(final LadderHeight height, final PlayerNames playerNames,
                                                        final List<LadderBridge> bridges) {
            //given
            BridgeGeneratorStub bridgeGeneratorStub = new BridgeGeneratorStub();
            bridgeGeneratorStub.setBridges(bridges);

            //when, then
            Assertions.assertThatCode(
                            () -> Ladder.create(height, playerNames.getCount(), bridgeGeneratorStub))
                    .doesNotThrowAnyException();
        }

        private static Stream<Arguments> createLadderSuccessWithHeightAndPointCountArguments() {
            return Stream.of(
                    Arguments.arguments(new LadderHeight(2),
                            new PlayerNames(List.of(new PlayerName("a"), new PlayerName("b"))),
                            List.of(LadderBridge.BRIDGE, LadderBridge.NONE)
                    ),

                    Arguments.arguments(new LadderHeight(10),
                            new PlayerNames(List.of(new PlayerName("a"), new PlayerName("b"), new PlayerName("c"),
                                    new PlayerName("d"), new PlayerName("e"), new PlayerName("f"), new PlayerName("g"),
                                    new PlayerName("h"), new PlayerName("i"), new PlayerName("j"))),
                            List.of(LadderBridge.NONE, LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.BRIDGE,
                                    LadderBridge.NONE, LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.BRIDGE,
                                    LadderBridge.NONE, LadderBridge.BRIDGE))
            );
        }
    }

    @Nested
    @DisplayName("참가자 사다리 결과 테스트")
    class PlayerLadderResultTest {
        @ParameterizedTest
        @MethodSource("getSinglePlayerLadderResultSuccessArguments")
        @DisplayName("단일 참가자의 결과를 출력한다")
        void getSinglePlayerLadderResultSuccess(final LadderHeight height, final LadderResults results,
                                                final PlayerNames playerNames, final List<LadderBridge> bridges) {
            //given
            BridgeGeneratorStub bridgeGeneratorStub = new BridgeGeneratorStub();
            bridgeGeneratorStub.setBridges(bridges);
            Ladder ladder = Ladder.create(height, playerNames.getCount(), bridgeGeneratorStub);

            //when
            Map<String, String> player1Result = ladder.findSinglePlayerLadderResultValue("pA", playerNames, results);
            Map<String, String> player2Result = ladder.findSinglePlayerLadderResultValue("pB", playerNames, results);
            Map<String, String> player3Result = ladder.findSinglePlayerLadderResultValue("pC", playerNames, results);

            //then
            assertAll(
                    () -> Assertions.assertThat(player1Result.get("pA")).isEqualTo("O"),
                    () -> Assertions.assertThat(player2Result.get("pB")).isEqualTo("X"),
                    () -> Assertions.assertThat(player3Result.get("pC")).isEqualTo("O")
            );
        }

        private static Stream<Arguments> getSinglePlayerLadderResultSuccessArguments() {
            return Stream.of(
                    Arguments.arguments(new LadderHeight(2),
                            new LadderResults(new String[]{"O", "X", "O"}, 3),
                            new PlayerNames(List.of(new PlayerName("pA"), new PlayerName("pB"), new PlayerName("pC"))),
                            List.of(LadderBridge.BRIDGE, LadderBridge.NONE)
                    )
            );
        }

        @ParameterizedTest
        @MethodSource("getAllPlayersLadderResultSuccessByArguments")
        @DisplayName("전체 참가자의 결과를 조회한다")
        void test(final LadderHeight height, final LadderResults results, final PlayerNames playerNames,
                  final List<LadderBridge> bridges) {
            //given
            BridgeGeneratorStub bridgeGeneratorStub = new BridgeGeneratorStub();
            bridgeGeneratorStub.setBridges(bridges);
            Ladder ladder = Ladder.create(height, playerNames.getCount(), bridgeGeneratorStub);

            //when
            Map<String, String> result = ladder.findAllPlayersLadderResultValue(playerNames, results);

            //then
            assertAll(
                    () -> Assertions.assertThat(result.get("pA")).isEqualTo("O"),
                    () -> Assertions.assertThat(result.get("pB")).isEqualTo("X"),
                    () -> Assertions.assertThat(result.get("pC")).isEqualTo("O")
            );
        }

        private static Stream<Arguments> getAllPlayersLadderResultSuccessByArguments() {
            return Stream.of(
                    Arguments.arguments(new LadderHeight(2),
                            new LadderResults(new String[]{"O", "X", "O"}, 3),
                            new PlayerNames(List.of(new PlayerName("pA"), new PlayerName("pB"), new PlayerName("pC"))),
                            List.of(LadderBridge.BRIDGE, LadderBridge.NONE)
                    )
            );
        }
    }
}
