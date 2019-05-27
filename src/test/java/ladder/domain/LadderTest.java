package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static ladder.domain.Ladder.goDownOneLine;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void 사다리_한줄일때_결과_테스트() {
        List<Integer> indices = Arrays.asList(0, 1, 2);
        Line line = new Line(Arrays.asList(
                new PointsTuple(Arrays.asList(false, true)),
                new PointsTuple(Arrays.asList(true, false)),
                new PointsTuple(Arrays.asList(false, false))));

        assertThat(goDownOneLine(indices, line)).isEqualTo(Arrays.asList(1, 0, 2));
    }


}
