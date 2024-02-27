package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class PlayersTest {

    @DisplayName("입력된 이름의 수가 2이상 10이하가 아닌 경우 예외를 발생한다.")
    @ParameterizedTest
    @MethodSource("playerNumberTestMethod")
    void playerNumberTest(List<String> input) {
        Assertions.assertThatThrownBy(() -> new Players(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 수는 2이상 10이하여야 합니다.");
    }

    private static Stream<Arguments> playerNumberTestMethod() {
        return Stream.of(
                Arguments.arguments(List.of("1")),
                Arguments.arguments(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
        );
    }

    @DisplayName("갖고 있는 List를 방어적 복사로 반환한다.")
    @Test
    void getNamesFromList() {
        Players players = new Players(List.of("test1", "test2"));
        Assertions.assertThat(players.getNames()
                        .stream()
                        .map(Name::getName)
                        .toList())
                .isEqualTo(List.of(new Name("test1").getName(), new Name("test2").getName()));
    }
}
