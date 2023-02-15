package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineMakerTest {

    private int playerCount;
    private RandomGenerator<Boolean> randomGenerator;

    @BeforeEach
    void setup() {
        playerCount = 5;
        randomGenerator = new RandomBooleanGenerator();
    }

    @Test
    @DisplayName("플레이어 수 -1 크기의 리스트가 생성되는지 확인한다.")
    void generateLineSizeTest() {
        assertThat(LineMaker.generate(playerCount, randomGenerator).size()).isEqualTo(playerCount - 1);
    }

    @RepeatedTest(100)
    @DisplayName("생성된 Line의 가로가 겹치지 않는지 확인한다.")
    void generateLineTest() {
        // 리스트가 연속된 true값을 갖지 않은지.
        List<Bar> bars = LineMaker.generate(playerCount, randomGenerator);

        for (int idx = 0; idx < bars.size() - 1; idx++) {
            Bar currentBar = bars.get(idx);
            Bar nextBar = bars.get(idx + 1);

            assertThat(!currentBar.getValue() || !nextBar.getValue())
                    .isTrue();
        }
    }
}
