package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineGeneratorTest {
    @Test
    void Line을_제대로_만드는지_확인() {
        LineGenerator lineGenerator = new LineGenerator();
        assertThat(new Line(3)).isEqualTo(lineGenerator.generate(3));
    }
}
