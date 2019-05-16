package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultMakerTest {
    @Test
    void 한명_결과계산() {
        List<Line> ladder = LadderMaker.generateLadder(3, 1);
        assertThat(ResultMaker.generateResult(ladder, 1)).isEqualTo(1);
    }

    @Test
    void 전체_결과계산() {
        List<Line> ladder = LadderMaker.generateLadder(3, 1);
        assertThat(ResultMaker.generateResultAll(ladder, 1)).isEqualTo(Arrays.asList(1));
    }
}
