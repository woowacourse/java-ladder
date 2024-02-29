package model.prize;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import model.player.Players;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PrizeTest {
    @DisplayName("사다리 실행 결과 보상 수는 참여자 수와 같다")
    @ParameterizedTest
    @MethodSource("provideValidSizeOfPrizes")
    void testValidSizeOfPrizes(List<String> playerNames, List<String> prizeNames) {
        Players players = Players.from(playerNames);
        Assertions.assertDoesNotThrow(() -> Prizes.of(players, prizeNames));
    }

    private static Stream<Arguments> provideValidSizeOfPrizes() {
        return Stream.of(
                Arguments.of(List.of("pobi", "doraa", "jojo"), List.of("꽝", "3000", "2000")),
                Arguments.of(List.of("pobi", "doraa"), List.of("꽝", "3000"))
        );
    }

    @DisplayName("사다리 실행 결과 보상 수가 참여자 수와 다르면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("provideInvalidSizeOfPrizes")
    void testInvalidSizeOfPrizes(List<String> playerNames, List<String> prizeNames) {
        Players players = Players.from(playerNames);
        assertThatThrownBy(() -> Prizes.of(players, prizeNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidSizeOfPrizes() {
        return Stream.of(
                Arguments.of(List.of("pobi", "doraa", "jojo"), List.of("꽝", "3000")),
                Arguments.of(List.of("pobi", "doraa"), List.of("꽝", "3000", "2000"))
        );
    }
}
