package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderBuilderTest {
    @Test
    public void build() {
        Line line = new Line(Arrays.asList(true, false));
        List<Line> lines = Arrays.asList(line);

        Ladder ladder = new Ladder(lines, 2);
        LadderBuilder ladderBuilder = new LadderBuilder(new MockLadderBuildStrategy());

        assertThat(ladderBuilder.build(new LadderHeight(1), 2)).isEqualTo(ladder);
    }
}
