package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {
    @Test
    void Ladder를_제대로_만드는지_확인() {
        LadderGenerator ladderGenerator = new LadderGenerator();
        assertThat(new Ladder(5, 3)).isEqualTo(ladderGenerator.generate(5, 3));
    }
}
