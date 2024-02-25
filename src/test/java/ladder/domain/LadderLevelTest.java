package ladder.domain;

import static ladder.domain.LadderDirection.LEFT;
import static ladder.domain.LadderDirection.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLevelTest {

    @DisplayName("사다리의 한 층은 입력받은 크기로 생성된다.")
    @Test
    void ladderLevelConstructTest() {
        LadderLevel ladderLevel = new LadderLevel(2);

        int actualSize = (int) ladderLevel.stream().count();

        assertThat(actualSize).isEqualTo(2);
    }

    @DisplayName("Direction.RIGHT과 Direction.LEFT는 한 쌍으로만 생성된다.")
    @Test
    void ladderLevelIntegrityTest() {
        LadderLevel ladderLevel = new LadderLevel(100);
        List<LadderDirection> ladderDirections = ladderLevel.stream().toList();

        List<Integer> rightIndices = IntStream.range(0, 100)
                .filter(index -> ladderDirections.get(index) == RIGHT)
                .boxed().toList();

        assertThat(rightIndices).allSatisfy(index ->
                assertThat(ladderDirections.get(index + 1)).isEqualTo(LEFT)
        );
    }
}
