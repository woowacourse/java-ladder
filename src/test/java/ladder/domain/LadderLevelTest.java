package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderLevelTest {

    static List<Direction> ladderLevelTest(int peopleCount) {
        List<Direction> result = new ArrayList<>();
        for (int i = 0; i < peopleCount; i++) {
            if (i % 2 != 0) {
                result.add(LEFT);
                continue;
            }
            result.add(RIGHT);
        }
        return result;
    }

    @DisplayName("가로줄은 연속으로 존재할 수 없다.")
    @Test
    void ladderLevelTest() {
        int peopleCount = 100;

        LadderLevel ladderLevel = new LadderLevel(peopleCount, () -> RIGHT);
        List<Direction> directions = ladderLevel.stream().toList();
        List<Direction> expected = ladderLevelTest(peopleCount);

        assertThat(directions).isEqualTo(expected);
    }

    @DisplayName("가로줄은 연속으로 존재할 수 없다.")
    @Test
    void laadderLevelTest() {
        int peopleCount = 100;

        LadderLevel ladderLevel = new LadderLevel(peopleCount, new DefaultLineGenerator());
        List<Direction> directions = ladderLevel.stream().toList();
        IntStream.range(0, peopleCount).forEach(index -> {
            if (directions.get(index) == RIGHT) {
                assertThat(directions.get(index + 1)).isEqualTo(LEFT);
            }
            if (directions.get(index) == LEFT) {
                assertThat(directions.get(index + 1)).isNotEqualTo(LEFT);
            }
        });
    }
}
