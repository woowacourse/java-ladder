package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리 높이와 사람 수, RandomGenerator을 입력받아 사다리 줄을 설정한다.")
    @Test
    void addLadderLine() {
        Height height = new Height("2");
        int peopleCount = 3;
        RandomGenerator randomGenerator = new RandomGenerator();
        Ladder ladder = new Ladder(height, peopleCount, randomGenerator);
        List<Line> result = ladder.getLines();

        assertThat(result).hasSize(2);
    }

    @DisplayName("사다리를 오르면 결과값이 위치하는 int 인덱스를 반환한다")
    @RepeatedTest(10)
    void climbLadder() {
        Height height = new Height("1");
        int peopleCount = 3;
        RandomGenerator randomGenerator = new RandomGenerator();

        Ladder ladder = new Ladder(height, peopleCount, randomGenerator);
        int index = 1;

        index = ladder.climbLadder(index);

        if (ladder.getLines().get(0).getLineStates().get(1) == LineState.START) {
            assertThat(index).isEqualTo(2);
        }

        if (ladder.getLines().get(0).getLineStates().get(1) == LineState.END) {
            assertThat(index).isEqualTo(0);
        }

        if (ladder.getLines().get(0).getLineStates().get(1) == LineState.NONE) {
            assertThat(index).isEqualTo(1);
        }
    }
}
