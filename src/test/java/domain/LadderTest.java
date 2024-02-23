package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리의 층이 제대로 생성된다.")
    void ladderHeightTest() {
        int floor = 5;
        Ladder ladder = new Ladder(floor, 5);
        Assertions.assertThat(ladder.getLines().size())
                .isEqualTo(floor);

    }

    @Test
    @DisplayName("사다리의 칸의 개수가 제대로 생성된다.")
    void ladderCellTest() {
        int participantsCount = 5;
        Ladder ladder = new Ladder(5, participantsCount);
        Line firstFloor = ladder.getLines().get(0);
        Assertions.assertThat(firstFloor.getStepPoints().size())
                .isEqualTo(participantsCount - 1);

    }

}
