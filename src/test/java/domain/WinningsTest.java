package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class WinningsTest {
    @DisplayName("입력된 이름의 수가 2이상 10이하가 아닌 경우 예외를 발생한다.")
    @ParameterizedTest
    @MethodSource("winningsNumberTestMethod")
    void winningsNumberTest(List<String> input) {
        Assertions.assertThatThrownBy(() -> new Winnings(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행결과의 수는 2이상 10이하여야 합니다.");
    }

    private static Stream<Arguments> winningsNumberTestMethod() {
        return Stream.of(
                Arguments.arguments(List.of("1")),
                Arguments.arguments(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
        );
    }

    @DisplayName("갖고 있는 List를 iterator로 반환한다.")
    @Test
    void getWinningFromIteratorTest() {
        Winnings winnings = new Winnings(List.of("test1", "test2"));
        Iterator<Winning> iterator = winnings.iterator();
        List<String> test = new ArrayList<>();
        while (iterator.hasNext()) {
            test.add(iterator.next().getWinning());
        }
        Assertions.assertThat(test)
                .isEqualTo(List.of(new Winning("test1").getWinning(), new Winning("test2").getWinning()));
    }

    @DisplayName("Players 와 다른 개수의 실행결과를 받은 경우 예외를 출력한다.")
    @Test
    void getWinningNumberDifferentFromPlayersTest() {
        Players players = new Players(List.of("1", "2", "3"));
        Winnings winnings = new Winnings(List.of("1", "2"));
        Assertions.assertThatThrownBy(() -> winnings.isSameNumberWithPlayers(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람 이름과 같은 개수를 입력하여야 합니다.");
    }
}
