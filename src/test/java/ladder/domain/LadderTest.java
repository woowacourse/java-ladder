package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void create() {
        List<Line> lines = new ArrayList<>();
        List<Line> lines2 = new ArrayList<>();
        Line line = new Line();

        line.connect(new MockLadderBuildStrategy(), 0);

        lines.add(line);
        lines2.add(new Line());

        Ladder ladder = new Ladder(lines, 1);
        Ladder ladder2 = new Ladder(lines2, 1);

        ladder2.connect(new MockLadderBuildStrategy(), 0, 0);

        assertThat(ladder).isEqualTo(ladder2);
    }

    @Test
    public void connect() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line());

        Ladder ladder = new Ladder(lines, 1);

        assertThat(ladder.getLine(0).isConnected(0)).isFalse();

        ladder.connect(new MockLadderBuildStrategy(), 0, 0);
        assertThat(ladder.getLine(0).isConnected(0)).isTrue();
    }

    @Test
    public void play() {
        LadderBuilder ladderBuilder = new LadderBuilder();
        Ladder ladder = ladderBuilder.build(new LadderHeight(1), 1, new MockLadderBuildStrategy());
        List<Integer> result = new ArrayList<>();

        result.add(0);

        assertThat(ladder.play()).isEqualTo(new LadderResult(result));
    }
}
