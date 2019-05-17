package ladder.domain.generator;

import ladder.domain.generator.SubLineGenerator;
import ladder.domain.generator.SubLineRandomGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubLineGeneratorTest {
    @Test
    void 라인_그리기_테스트() {
        int countOfPlayers = 5;
        SubLineGenerator subLineGenerator = new SubLineRandomGenerator(countOfPlayers);

        assertThat(subLineGenerator.generate().size()).isEqualTo(countOfPlayers-1);
    }
}
