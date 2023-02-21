package domain.ladder;

import domain.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.FixBooleanGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리는 ")
class LadderTest {
    @Nested
    @DisplayName("다리를 건널 때 ")
    class CrossingLadderCase {
        @ParameterizedTest(name = "{0} -> {1}")
        @DisplayName("출발지의 인덱스를 받으면 사다리를 진행한 후, 도착지의 인덱스를 가져온다.")
        @CsvSource(value = {"0,2", "1,0", "2,1"})
        void givenStaringPoint_thenReturnsGoalPoint(int startingPoint, int expectedGoalPoint) {
            Ladder ladder = Ladder.of(new FixBooleanGenerator(true, false, true, false, false));
            ladder.build(Height.of(3), 3);

            int goalPoint = ladder.ride(startingPoint, 0);

            assertThat(goalPoint).isEqualTo(expectedGoalPoint);
        }
    }
}