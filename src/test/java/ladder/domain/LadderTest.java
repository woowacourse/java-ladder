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

        Ladder ladder = new Ladder(lines);
        Ladder ladder2 = new Ladder(lines2);

        ladder2.connect(new MockLadderBuildStrategy(), 0, 0);

        assertThat(ladder).isEqualTo(ladder2);
    }

    @Test
    public void connect() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line());

        Ladder ladder = new Ladder(lines);

        assertThat(ladder.getLine(0).isConnected(0)).isFalse();

        ladder.connect(new MockLadderBuildStrategy(), 0, 0);
        assertThat(ladder.getLine(0).isConnected(0)).isTrue();
    }
}
