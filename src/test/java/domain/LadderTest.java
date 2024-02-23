package domain;

import common.exception.model.ValidationException;
import domain.bridge.strategy.RandomBridgeGenerator;
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
    @DisplayName("사다리 생성 테스트")
    class LadderCreateTest {
        @ParameterizedTest
        @MethodSource("createLadderSuccessWithHeightAndPointCountArguments")
        @DisplayName("사다리 높이가 2 이상, 10 이하이며 사람의 수가 2 이상, 10 이하이면 정상적으로 생성된다")
        void createLadderSuccessWithHeightAndPointCount(LadderHeight height, PlayerNames playerNames) {
            Assertions.assertThatCode(
                            () -> Ladder.create(height, playerNames, new RandomBridgeGenerator()))
                    .doesNotThrowAnyException();
        }

        private static Stream<Arguments> createLadderSuccessWithHeightAndPointCountArguments() {
            return Stream.of(
                    Arguments.arguments(new LadderHeight(String.valueOf(2)),
                            new PlayerNames(List.of(new PlayerName("a"), new PlayerName("b")))),

                    Arguments.arguments(new LadderHeight(String.valueOf(10)),
                            new PlayerNames(List.of(new PlayerName("a"), new PlayerName("b"), new PlayerName("c"),
                                    new PlayerName("d"), new PlayerName("e"), new PlayerName("f"), new PlayerName("g"),
                                    new PlayerName("h"), new PlayerName("i"), new PlayerName("j"))))
            );
        }

        @ParameterizedTest
        @MethodSource("createLadderFailByHeightAndPointCountArguments")
        @DisplayName("사다리 높이가 2 이상, 10 이하이며 사람의 수가 2 이상, 10 이하이면 정상적으로 생성된다")
        void createLadderFailByHeightAndPointCount(LadderHeight height, PlayerNames playerNames) {
            Assertions.assertThatThrownBy(
                            () -> Ladder.create(height, playerNames, new RandomBridgeGenerator()))
                    .isInstanceOf(ValidationException.class);
        }

        private static Stream<Arguments> createLadderFailByHeightAndPointCountArguments() {
            return Stream.of(
                    Arguments.arguments(new LadderHeight(String.valueOf(2)),
                            new PlayerNames(List.of(new PlayerName("a")))),

                    Arguments.arguments(new LadderHeight(String.valueOf(10)),
                            new PlayerNames(List.of(new PlayerName("a"), new PlayerName("b"), new PlayerName("c"),
                                    new PlayerName("d"), new PlayerName("e"), new PlayerName("f"), new PlayerName("g"),
                                    new PlayerName("h"), new PlayerName("i"), new PlayerName("j"), new PlayerName("k"))))
            );
        }
    }
}
