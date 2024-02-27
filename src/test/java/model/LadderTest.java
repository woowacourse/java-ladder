package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderTest {
    /*
        |-----|     |-----|
        |     |-----|     |
        |_____|     |     |

        0 -> 2
        1 -> 1
        2 -> 3
        3 -> 0

        */
    @Test
    void 사다리_높이만큼_이동하며_현재위치를_업데이트한다() {
        int startIndex = 0;
        Layer firstLayer = new Layer(List.of(Step.EXIST, Step.EMPTY, Step.EXIST));
        Layer secondLayer = new Layer(List.of(Step.EMPTY, Step.EXIST, Step.EMPTY));
        Layer thirdLayer = new Layer(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY));
        Ladder ladder = new Ladder(List.of(firstLayer, secondLayer, thirdLayer));
        int expectedMovedIndex = 2;

        assertThat(ladder.climbDownEach(startIndex)).isEqualTo(expectedMovedIndex);
    }
}
