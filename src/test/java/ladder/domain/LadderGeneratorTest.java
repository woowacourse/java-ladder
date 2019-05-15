package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {
    @Test
    void Ladder를_제대로_만드는지_확인() {
        List<Line> lines = new ArrayList<>();
        int height = 3;

        LineGenerator lineGenerator = new LineGenerator();
        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.generate(5));
        }

        LadderGenerator ladderGenerator = new LadderGenerator();
        assertThat(new Ladder(lines)).isEqualTo(ladderGenerator.generate(5, 3));
    }
}
