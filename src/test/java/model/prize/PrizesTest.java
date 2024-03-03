package model.prize;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import model.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizesTest {

    @DisplayName("실행 결과 수가 참여자 등록 수와 같으면 객체 생성 성공")
    @ParameterizedTest
    @MethodSource("provideValidPrizeNamesAndPlayers")
    void testValidPrizesSize(List<String> prizeNames, Players players) {
        assertThatCode(() -> Prizes.of(prizeNames, players))
            .doesNotThrowAnyException();
    }

    private static Stream<Arguments> provideValidPrizeNamesAndPlayers() {
        return Stream.of(
            Arguments.of(List.of("꽝", "식권"), Players.of(List.of("pobi", "dora"))),
            Arguments.of(List.of("배민상품권", "꽝", "꽝"), Players.of(List.of("pobi", "doraa", "jojo")))
        );
    }

    @DisplayName("실행 결과 수가 참여자 등록 수와 다르면 예외 발생")
    @ParameterizedTest
    @MethodSource("provideInvalidPrizeNamesAndPlayers")
    void testInvalidPlayersSize(List<String> prizeNames, Players players) {
        assertThatThrownBy(() -> Prizes.of(prizeNames, players))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidPrizeNamesAndPlayers() {
        return Stream.of(
            Arguments.of(List.of("꽝", "식권", "꽝"), Players.of(List.of("pobi", "dora"))),
            Arguments.of(List.of("배민상품권", "꽝"), Players.of(List.of("pobi", "doraa", "jojo"))),
            Arguments.of(List.of(), Players.of(List.of("doraa", "jojo")))
        );
    }
}
