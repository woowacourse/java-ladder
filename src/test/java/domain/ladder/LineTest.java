package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.generator.LadderStepGenerator;
import domain.generator.RandomLadderStepGenerator;
import domain.generator.ExistsLadderStepGenerator;
import domain.player.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineTest {
    private final LadderStepGenerator randomLadderGenerator = new RandomLadderStepGenerator();
    private final LadderStepGenerator nonRandomLadderGenerator = new ExistsLadderStepGenerator();

    @DisplayName("사다리 값에 따라서 사다리를 생성할 수 있다.")
    @Nested
    class createLineTest {
        @DisplayName("랜덤으로 사다리를 생성할 수 있다.")
        @Test
        void createRandomLineTest() {
            assertDoesNotThrow(() -> new Line(3, randomLadderGenerator));
        }

        @DisplayName("같은 값을 입력하면 항상 같은 사다리가 생성된다.")
        @Test
        void createNonRandomLadderStepsTest() {
            assertThat(new Line(3, nonRandomLadderGenerator).getLadderSteps())
                    .containsExactly(LadderStep.EXISTS, LadderStep.NONE, LadderStep.EXISTS);
        }
    }

    @DisplayName("각 방향으로 움직일 수 있는지 확인할 수 있다.")
    @Nested
    class canMoveTest {
        private final Line line = new Line(5, nonRandomLadderGenerator);

        /*
        |-----|     |-----|     |-----|
        */

        @DisplayName("왼쪽으로 움질일 수 있는지 확인할 수 있다.")
        @ParameterizedTest
        @CsvSource({
                "0,false",
                "1,true",
                "2,false",
                "3,true",
                "4,false",
                "5,true"}
        )
        void canMoveLeftTest(int index, boolean expected) {
            assertThat(line.canMoveLeft(new Position(index))).isEqualTo(expected);
        }

        @DisplayName("오른쪽으로 움질일 수 있는지 확인할 수 있다.")
        @ParameterizedTest
        @CsvSource({
                "0,true",
                "1,false",
                "2,true",
                "3,false",
                "4,true",
                "5,false"}
        )
        void canMoveRightTest(int index, boolean expected) {
            assertThat(line.canMoveRight(new Position(index))).isEqualTo(expected);
        }
    }
}
