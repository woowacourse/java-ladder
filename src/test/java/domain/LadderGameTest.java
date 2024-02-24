package domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderGameTest {

    static Stream<Arguments> climbParameter() {
        return Stream.of(
                Arguments.of("a", List.of("2")),
                Arguments.of("b", List.of("1")),
                Arguments.of("c", List.of("3")),
                Arguments.of("all", List.of("2", "1", "3"))
        );
    }

    @Test
    @DisplayName("사다리 타기 게임의 이름이 제대로 저장되는지 검증")
    void getRawNames() {
        List<String> expectedRawNames = List.of("a", "b");
        List<String> rawResults = List.of("1,2");
        LadderGame ladderGame = new LadderGame(expectedRawNames, 5, rawResults);
        List<String> actualRawNames = ladderGame.getRawNames();
        Assertions.assertThat(actualRawNames)
                .containsExactlyElementsOf(expectedRawNames);
    }

    @Test
    @DisplayName("사다리 타기 게임의 사다리가 제대로 생성되는지 검증")
    void getRawLadder() {
        List<String> expectedRawNames = List.of("a", "b");
        List<String> rawResults = List.of("1,2");
        int ladderHeight = 5;
        LadderGame ladderGame = new LadderGame(expectedRawNames, ladderHeight, rawResults);
        List<List<Boolean>> actualRawLadder = ladderGame.getRawLadder();
        Assertions.assertThat(actualRawLadder.size())
                .isEqualTo(ladderHeight);
        Assertions.assertThat(actualRawLadder.get(0).size())
                .isEqualTo(expectedRawNames.size() - 1);
    }

    @Test
    @DisplayName("사다리 타기 게임의 실행 결과가 제대로 저장되는지 검증")
    void getRawResults() {
        List<String> rawNames = List.of("a", "b");
        List<String> expectedRawResults = List.of("1,2");
        int ladderHeight = 5;
        LadderGame ladderGame = new LadderGame(rawNames, ladderHeight, expectedRawResults);
        List<String> actualRawResults = ladderGame.getRawResults();
        Assertions.assertThat(actualRawResults)
                .containsExactlyElementsOf(expectedRawResults);
    }

    @ParameterizedTest
    @MethodSource("climbParameter")
    @DisplayName("사다리 타기 게임을 실행했을 때, 제대로 사다리가 타지는지 검증")
    void climb(String nameThatWantToShoResult, List<String> expectedResult) {
        List<String> expectedRawNames = List.of("a", "b", "c");
        List<String> rawResults = List.of("1", "2", "3");
        int ladderHeight = 5;
        LadderGame ladderGame = new LadderGame(expectedRawNames, ladderHeight, rawResults,
                width -> List.of(true, false));
        List<String> climbResults = ladderGame.getClimbResults(nameThatWantToShoResult);
        Assertions.assertThat(climbResults)
                .isEqualTo(expectedResult);
    }
}
