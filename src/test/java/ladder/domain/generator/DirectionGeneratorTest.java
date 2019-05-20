package ladder.domain.generator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionGeneratorTest {
    @Test
    void 라인_그리기_테스트() {
        int countOfPlayers = 5;
        DirectionGenerator directionGenerator = new DirectionRandomGenerator(countOfPlayers);

        assertThat(directionGenerator.generate().size()).isEqualTo(countOfPlayers);
    }
}
