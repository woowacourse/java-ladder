package domain.ladder;

import domain.Goals;
import domain.Height;
import domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.FixBooleanGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리는 ")
class LadderTest {
    @Nested
    @DisplayName("다리를 건널 때 ")
    class CrossingLadderCase {
        @ParameterizedTest(name = "{0} -> {1}")
        @DisplayName("출발지의 인덱스를 받으면 사다리를 진행한 후, 도착지의 인덱스를 가져온다.")
        @CsvSource(value = {"참가자1,골3", "참가자2,골1", "참가자3,골2"})
        void givenStaringPoint_thenReturnsGoalPoint(String participantName, String expectedGoalName) {
            Ladder ladder = Ladder.of(new FixBooleanGenerator(true, false, true, false, false),
                    Players.ofValues(List.of("참가자1", "참가자2", "참가자3")),
                    Goals.of(3, List.of("골1", "골2", "골3")));
            ladder.build(Height.of(3), 3);

            String goalName = ladder.ride(participantName);

            assertThat(goalName).isEqualTo(expectedGoalName);
        }
    }
}