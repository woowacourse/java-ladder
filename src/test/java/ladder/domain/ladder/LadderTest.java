package ladder.domain.ladder;

import ladder.domain.linegenerator.impl.RandomLineGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;
    @BeforeEach
    void setUp() {
        ladder = new Ladder(new RandomLineGenerator(3), new Height(3));
    }

    @Test
    void 생성되는_line_수() {
        assertThat(ladder.getLines().size()).isEqualTo(3);
    }

    @Test
    void 생성된_line의_Direction수() {
        Line line = ladder.getLines().get(0);
        assertThat(line.getDirections().size()).isEqualTo(3);
    }
}
