package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineGeneratorTest {
    @Test
    public void Line을_잘_만드는지_확인() {
        MockLineGenerator mockLineGenerator = new MockLineGenerator();
        Line lineByGenerator = mockLineGenerator.generate(4);
        Line lineByMe = new Line(Arrays.asList(true, false, true, false));

        assertThat(lineByGenerator).isEqualTo(lineByMe);
    }
}
