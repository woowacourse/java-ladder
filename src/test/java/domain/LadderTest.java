package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PresentStepGenerator;

class LadderTest {

    @Test
    @DisplayName("사다리의 층이 제대로 생성된다.")
    void ladderHeightTest() {
        int floor = 5;
        Ladder ladder = new Ladder(floor, 5, new PresentStepGenerator());
        Assertions.assertThat(ladder.getLines().size())
                .isEqualTo(floor);

    }

    @Test
    @DisplayName("사다리의 칸의 개수가 제대로 생성된다.")
    void ladderCellTest() {
        int participantsCount = 5;
        Ladder ladder = new Ladder(5, participantsCount, new PresentStepGenerator());
        Line firstFloor = ladder.getLines().get(0);
        Assertions.assertThat(firstFloor.getStepPoints().size())
                .isEqualTo(participantsCount - 1);
    }

    @Test
    @DisplayName("사다리의 특정 위치에서 왼쪽으로 이동 가능한지 확인한다.")
    void canMoveLeftTest() {
        Ladder ladder = new Ladder(5, 5, new PresentStepGenerator());
        Assertions.assertThat(ladder.canMoveLeft(0, 1)).isTrue();
    }

    @Test
    @DisplayName("사다리의 특정 위치에서 오른쪽으로 이동 가능한지 확인한다.")
    void canMoveRightTest() {
        Ladder ladder = new Ladder(5, 5, new PresentStepGenerator());
        Assertions.assertThat(ladder.canMoveRight(0, 1)).isFalse();
    }

    @Test
    @DisplayName("사다리의 끝까지 왔는지 확인한다.")
    void isFinishTest() {
        Ladder ladder = new Ladder(5, 5, new PresentStepGenerator());
        Assertions.assertThat(ladder.isFinish(4)).isFalse();
    }

}
