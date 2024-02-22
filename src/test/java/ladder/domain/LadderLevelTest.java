package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLevelTest {

    @DisplayName("사다리 층 생성")
    @Test
    void ladderLevelConstructTest() {
        assertThatCode(() -> new LadderLevel(5, new DefaultLineGenerator()))
                .doesNotThrowAnyException();
    }

    /**
     * Direction.RIGHT Direction.LEFT는 함께 생성된다. <br>
     * RIGHT-LEFT 쌍은 가로줄 한 개를 의미한다.
     */
    @DisplayName("가로줄 검증")
    @Test
    void ladderLevelIntegrityTest() {
        // given
        LadderLevel ladderLevel = new LadderLevel(100, new DefaultLineGenerator());
        List<Direction> directions = ladderLevel.stream().toList();

        //when
        List<Integer> rightIndices = new ArrayList<>();
        List<Integer> leftIndices = new ArrayList<>();

        IntStream.range(0, directions.size()).forEach(index -> {
            if (directions.get(index) == RIGHT) {
                rightIndices.add(index);
            }
            if (directions.get(index) == LEFT) {
                leftIndices.add(index);
            }
        });

        List<Integer> expected = rightIndices.stream().mapToInt(index -> index + 1).boxed().toList();

        //then
        assertThat(expected).containsExactlyElementsOf(leftIndices);
    }
}
