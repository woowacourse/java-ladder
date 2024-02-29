package domain;

import static domain.ladder.Height.MAX_OF_HEIGHT;
import static domain.ladder.Height.MIN_OF_HEIGHT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PresentStepGenerator;

class LadderTest {

    @Test
    @DisplayName("사다리의 층이 제대로 생성된다.")
    void ladderHeightTest() {
        int height = 5;
        Ladder ladder = new Ladder(new Height(height), 5, new PresentStepGenerator());
        Assertions.assertThat(ladder.getLines().size())
                .isEqualTo(height);

    }

    @Test
    @DisplayName("사다리의 칸의 개수가 제대로 생성된다.")
    void ladderCellTest() {
        int participantsCount = 5;
        Ladder ladder = new Ladder(new Height(5), participantsCount, new PresentStepGenerator());
        Line firstFloor = ladder.getLines().get(0);
        Assertions.assertThat(firstFloor.getStepPoints().size())
                .isEqualTo(participantsCount - 1);
    }

    @Test
    @DisplayName("사다리의 특정 위치에서 왼쪽으로 이동 가능한지 확인한다.")
    void canMoveLeftTest() {
        Ladder ladder = new Ladder(new Height(5), 5, new PresentStepGenerator());
        Assertions.assertThat(ladder.canMoveLeft(new Height(0), 1)).isTrue();
    }

    @Test
    @DisplayName("사다리의 특정 위치에서 오른쪽으로 이동 가능한지 확인한다.")
    void canMoveRightTest() {
        Ladder ladder = new Ladder(new Height(5), 5, new PresentStepGenerator());
        Assertions.assertThat(ladder.canMoveRight(new Height(0), 1)).isFalse();
    }

    @Test
    @DisplayName("사다리의 끝까지 왔는지 확인한다.")
    void isFinishTest() {
        Ladder ladder = new Ladder(new Height(5), 5, new PresentStepGenerator());
        Assertions.assertThat(ladder.isFinish(new Height(4))).isFalse();
    }

    @Test
    @DisplayName("높이가 " + Ladder.MIN_OF_HEIGHT + "개 미만이면 예외가 발생한다.")
    void lessThanOneExceptionTest() {
        assertThatThrownBy(() -> new Ladder(new Height(0), 5, new PresentStepGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 높이가 " + Ladder.MIN_OF_HEIGHT + "인 사다리는 불가능합니다.");
    }


}
