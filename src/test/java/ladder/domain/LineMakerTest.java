package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineMakerTest {
    private LineMaker lineMaker;
    private int playerCount;
    private RandomGenerator<Boolean> randomGenerator;

    @BeforeEach
    void setup() {
        playerCount = 5;
        randomGenerator = new RandomBooleanGenerator();
        lineMaker = new LineMaker(playerCount, randomGenerator);
    }
    @Test
    @DisplayName("플레이어 숫자대로 리스트가 생성되는지 확인한다.")
    void generateLineSizeTest() {
        assertThat(lineMaker.generateLine().size()).isEqualTo(playerCount);
    }

    @Test
    @DisplayName("생성된 Line의 가로가 겹치지 않는지 확인한다.")
    void generateLineTest() {
        // 리스트가 연속된 true값을 갖지 않은지.
        List<Boolean> bars = lineMaker.generateLine();
        for (int idx = 0; idx < bars.size() - 1; idx++) {
            assertThat(!bars.get(idx) || !bars.get(idx + 1)).isTrue();
        }
    }
}
