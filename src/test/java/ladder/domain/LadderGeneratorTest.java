package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {
    private static final int HEIGHT = 4;

    @Test
    public void Ladder를_잘_만드는지_확인() {
        MockLadderGenerator mockLadderGenerator = new MockLadderGenerator();
        Ladder ladderByGenerator = mockLadderGenerator.generate(HEIGHT, 4);

        Line lineByMe = new Line(Arrays.asList(true, false, true, false));
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < HEIGHT; i++) {
            lines.add(lineByMe);
        }
        Ladder ladderByMe = new Ladder(lines);

        assertThat(ladderByGenerator).isEqualTo(ladderByMe);
    }
}
