package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;
import domain.bridge.strategy.BridgeGeneratorStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LadderTest {

    @Nested
    @DisplayName("사다리 높이, 사람 수 테스트")
    class LadderHeightTest {
        @ParameterizedTest
        @MethodSource("createLadderSuccessWithHeightAndPointCountArguments")
        @DisplayName("사다리 높이가 2 이상, 10 이하이며 사람의 수가 2 이상, 10 이하이면 정상적으로 생성된다")
        void createLadderSuccessWithHeightAndPointCount(LadderHeight height, LadderResults results, PlayerNames playerNames, List<LadderBridge> bridges) {
            //given
            BridgeGeneratorStub bridgeGeneratorStub = new BridgeGeneratorStub();
            bridgeGeneratorStub.setBridges(bridges);

            //when, then
            Assertions.assertThatCode(
                            () -> Ladder.create(height, playerNames, results, bridgeGeneratorStub))
                    .doesNotThrowAnyException();
        }

        private static Stream<Arguments> createLadderSuccessWithHeightAndPointCountArguments() {
            return Stream.of(
                    Arguments.arguments(new LadderHeight(2),
                            new LadderResults(new String[]{"R", "R"}, 2),
                            new PlayerNames(List.of(new PlayerName("a"), new PlayerName("b"))),
                            List.of(LadderBridge.BRIDGE, LadderBridge.NONE)
                    ),

                    Arguments.arguments(new LadderHeight(10),
                            new LadderResults(new String[]{"R", "R", "R", "R", "R", "R", "R", "R", "R", "R"}, 10),
                            new PlayerNames(List.of(new PlayerName("a"), new PlayerName("b"), new PlayerName("c"),
                                    new PlayerName("d"), new PlayerName("e"), new PlayerName("f"), new PlayerName("g"),
                                    new PlayerName("h"), new PlayerName("i"), new PlayerName("j"))),
                            List.of(LadderBridge.NONE, LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.BRIDGE,
                                    LadderBridge.NONE, LadderBridge.BRIDGE, LadderBridge.NONE, LadderBridge.BRIDGE,
                                    LadderBridge.NONE, LadderBridge.BRIDGE))
            );
        }

        @ParameterizedTest
        @MethodSource("createLadderFailByPlayerCountArguments")
        @DisplayName("사람의 수가 2 미만, 10 초과이면 사다리 높이가 2 이상, 10 이상이어도 예외가 발생한다")
        void createLadderFailByHeightAndPointCount(LadderHeight height, LadderResults results, List<PlayerName> playerNames) {
            Assertions.assertThatThrownBy(
                            () -> Ladder.create(height, new PlayerNames(playerNames), results, new BridgeGeneratorStub()))
                    .isInstanceOf(ValidationException.class)
                    .hasMessage(ExceptionMessage.PLAYER_NAMES_RANGE);
        }

        private static Stream<Arguments> createLadderFailByPlayerCountArguments() {
            return Stream.of(
                    Arguments.arguments(new LadderHeight(2),
                            new LadderResults(new String[]{"R"}, 1),
                            List.of(new PlayerName("a"))),

                    Arguments.arguments(new LadderHeight(10),
                            new LadderResults(new String[]{"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"}, 11),
                            List.of(new PlayerName("a"), new PlayerName("b"), new PlayerName("c"),
                                    new PlayerName("d"), new PlayerName("e"), new PlayerName("f"), new PlayerName("g"),
                                    new PlayerName("h"), new PlayerName("i"), new PlayerName("j"), new PlayerName("k")))
            );
        }
    }

    @ParameterizedTest
    @MethodSource("createLadderFailByHeightArguments")
    @DisplayName("사다리 높이가 2 미만, 10 초과이면 사람의 수가 2 이상, 10 이하여도 예외가 발생한다")
    void createLadderFailByHeightAndPointCount(int height, LadderResults results, PlayerNames playerNames) {
        Assertions.assertThatThrownBy(
                        () -> Ladder.create(new LadderHeight(height), playerNames, results, new BridgeGeneratorStub()))
                .isInstanceOf(ValidationException.class);
    }

    private static Stream<Arguments> createLadderFailByHeightArguments() {
        return Stream.of(
                Arguments.arguments(1,
                        new LadderResults(new String[]{"R", "R"}, 2),
                        new PlayerNames(List.of(new PlayerName("a"), new PlayerName("b")))),

                Arguments.arguments(11,
                        new LadderResults(new String[]{"R", "R", "R", "R", "R", "R", "R", "R", "R", "R"}, 10),
                        new PlayerNames(List.of(new PlayerName("a"), new PlayerName("b"), new PlayerName("c"),
                                new PlayerName("d"), new PlayerName("e"), new PlayerName("f"), new PlayerName("g"),
                                new PlayerName("h"), new PlayerName("i"), new PlayerName("j"))))
        );
    }
}
