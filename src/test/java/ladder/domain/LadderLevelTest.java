package ladder.domain;

import static ladder.domain.LadderDirection.LEFT;
import static ladder.domain.LadderDirection.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLevelTest {

    @DisplayName("사다리 층을 생성한다.")
    @Test
    void ladderLevelConstructTest() {
        Players players = new Players(List.of("명오", "제우스"));
        assertThatCode(() -> new LadderLevel(players.count()))
                .doesNotThrowAnyException();
    }

    /**
     * Direction.RIGHT Direction.LEFT는 함께 생성된다. <br>
     * RIGHT-LEFT 쌍은 가로줄 한 개를 의미한다.
     */
    @DisplayName("가로줄이 올바르게 생성되는 지 검증")
    @Test
    void ladderLevelIntegrityTest() {
        // given
        LadderLevel ladderLevel = new LadderLevel(100);
        List<LadderDirection> ladderDirections = ladderLevel.stream().toList();

        //when
        List<Integer> rightIndices = new ArrayList<>();
        List<Integer> leftIndices = new ArrayList<>();

        IntStream.range(0, ladderDirections.size()).forEach(index -> {
            if (ladderDirections.get(index) == RIGHT) {
                rightIndices.add(index);
            }
            if (ladderDirections.get(index) == LEFT) {
                leftIndices.add(index);
            }
        });

        List<Integer> expected = rightIndices.stream().mapToInt(index -> index + 1).boxed().toList();

        //then
        assertThat(leftIndices).containsExactlyElementsOf(expected);
    }
}
