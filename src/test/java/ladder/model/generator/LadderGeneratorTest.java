package ladder.model.generator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {

    @Test
    void 생성된_사다리의_높이가_5인지_테스트() {
        assertThat(LadderGenerator.generateLadder(2, 5)
                .ladderStructure()
                .size()).isEqualTo(5);
    }
}
