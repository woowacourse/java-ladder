package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static ladder.domain.ladder.Path.EMPTY;
import static ladder.domain.ladder.Path.EXIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LadderStepTest {
    @Test
    @DisplayName("사다리 스탭을 생성한다.")
    void createLadderStepTest() {
        // given
        final List<Path> ladderStep = List.of(EXIST, EMPTY, EXIST, EMPTY);

        // when & then
        assertThatCode(() -> new LadderStep(ladderStep))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("getContinuousAndExpectedResult")
    @DisplayName("연속된 사다리 발판이 생성자의 매개변수로 넘어올 경우 보정된다.")
    void checkContinuousPathTest(List<Path> continuousLadderStep, List<Path> expectedResult) {
        // when
        final LadderStep ladderStep = new LadderStep(continuousLadderStep);

        // then
        final List<Path> correctedLadderStep = ladderStep.getLadderPaths();
        assertThat(correctedLadderStep).isEqualTo(expectedResult);
    }

    static Stream<Arguments> getContinuousAndExpectedResult() {
        return Stream.of(
                Arguments.arguments(List.of(EXIST, EXIST), List.of(EXIST, EMPTY)),
                Arguments.arguments(List.of(EXIST, EXIST, EXIST, EMPTY), List.of(EXIST, EMPTY, EXIST, EMPTY)),
                Arguments.arguments(List.of(EXIST, EMPTY, EXIST, EXIST), List.of(EXIST, EMPTY, EXIST, EMPTY))
        );
    }
}
