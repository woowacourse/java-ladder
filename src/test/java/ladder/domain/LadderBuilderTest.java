package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderBuilderTest {
    @Test
    public void build() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line());

        Ladder ladder = new Ladder(lines, 1);
        ladder.connect(new MockLadderBuildStrategy(), 0, 0);

        LadderBuilder ladderBuilder = new LadderBuilder();

        assertThat(ladderBuilder.build(1, 1, new MockLadderBuildStrategy())).isEqualTo(ladder);
    }
}
