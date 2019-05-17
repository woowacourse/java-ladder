package ladder.domain.generator;

import ladder.domain.generator.LineGenerator;
import ladder.domain.generator.LineRandomGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineGeneratorTest {
    @Test
    void 사다리_그리기_테스트() {
        int countOfPlayer = 2;
        int height = 2;
        LineGenerator lineGenerator = new LineRandomGenerator(countOfPlayer, height);
        assertThat(lineGenerator.generate().size()).isEqualTo(2);
    }
}
