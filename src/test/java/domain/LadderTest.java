package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("층의 개수가 올바르게 생성된다.")
    void ladderHeightTest() {
        int floor = 5;
        Ladder ladder = new Ladder(floor, 3);
        int expected = floor;
        int actual = ladder.getLines().size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("칸의 개수가 올바르게 생성된다.")
    void ladderNumberOfCellTest() {
        int participantsCount = 3;
        Ladder ladder = new Ladder(5, participantsCount);
        int expected = participantsCount - 1;
        Line firstLine = ladder.getLines().get(0);
        int actual = firstLine.getStepPoints().size();

        assertThat(actual).isEqualTo(expected);
    }

}
