package ladder.domain.ladder;

import ladder.domain.generator.LadderStepGenerator;
import ladder.domain.generator.RandomLadderStepGenerator;
import ladder.domain.generator.TestLadderStepGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LadderTest {
    @Test
    @DisplayName("주어진 높이만큼 사다리를 생성한다.")
    void createLadderTest() {
        // given
        final int stepWidth = 3;
        final Height height = new Height(4);

        // when & then
        assertThatCode(() -> new Ladder(height, stepWidth, new RandomLadderStepGenerator()))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("getStartAndExpectedFinalPosition")
    @DisplayName("첫 사다리 위치로부터 사다리 타기를 실행하여 최종 위치를 구한다.")
    void playAndGetFinalPositionTest(int startPosition, int expectedPosition) {
        // given
        final int stepWidth = 3;
        final Height height = new Height(3);
        final LadderStepGenerator ladderStepGenerator = new TestLadderStepGenerator();
        final Ladder ladder = new Ladder(height, stepWidth, ladderStepGenerator);

        // when
        int finalPosition = ladder.playAt(startPosition);

        // then
        assertThat(finalPosition).isEqualTo(expectedPosition);
    }

    static Stream<Arguments> getStartAndExpectedFinalPosition() {
        return Stream.of(
                Arguments.arguments(0, 1),
                Arguments.arguments(1, 0),
                Arguments.arguments(2, 3),
                Arguments.arguments(3, 2)
        );
    }
}
