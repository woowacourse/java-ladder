package model.ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;
import model.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LadderResultTest {
    @DisplayName("사다리 실행 결과 수는 참여자 수와 같다")
    @ParameterizedTest
    @MethodSource("provideValidSizeOfLadderResult")
    void testValidSizeOfLadderResult(List<String> names, List<LadderResultContent> contents) {
        Players players = Players.from(names);
        assertDoesNotThrow(() -> LadderResult.of(players, contents));
    }

    private static Stream<Arguments> provideValidSizeOfLadderResult() {
        return Stream.of(
                Arguments.of(List.of("pobi", "doraa", "jojo"), List.of("꽝", "3000", "2000")),
                Arguments.of(List.of("pobi", "doraa"), List.of("꽝", "3000"))
        );
    }

    @DisplayName("사다리 실행 결과 수가 참여자 수와 다르면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("provideInvalidSizeOfLadderResult")
    void testInvalidSizeOfLadderResult(List<String> names, List<LadderResultContent> contents) {
        Players players = Players.from(names);
        assertThatThrownBy(() -> LadderResult.of(players, contents))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidSizeOfLadderResult() {
        return Stream.of(
                Arguments.of(List.of("pobi", "doraa", "jojo"), List.of("꽝", "3000")),
                Arguments.of(List.of("pobi", "doraa"), List.of("꽝", "3000", "2000"))
        );
    }
}
