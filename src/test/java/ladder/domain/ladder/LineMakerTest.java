package ladder.domain.ladder;

import ladder.domain.valueGenerator.BooleanGenerator;
import ladder.domain.valueGenerator.MockBooleanGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineMakerTest {

    private int playerCount;
    private BooleanGenerator booleanGenerator;

    @BeforeEach
    void setup() {
        playerCount = 5;
        booleanGenerator = new MockBooleanGenerator(List.of(true));
    }

    @Test
    @DisplayName("플레이어 수 -1 크기의 리스트가 생성되는지 확인한다.")
    void generateLineSizeTest() {
        assertThat(LineMaker.generate(playerCount, booleanGenerator).size()).isEqualTo(playerCount - 1);
    }

    @RepeatedTest(100)
    @DisplayName("생성된 Line의 가로가 겹치지 않는지 확인한다.")
    void generateLineTest() {
        List<Bar> bars = LineMaker.generate(playerCount, booleanGenerator);

        for (int idx = 0; idx < bars.size() - 1; idx++) {
            Bar currentBar = bars.get(idx);
            Bar nextBar = bars.get(idx + 1);

            assertThat(!currentBar.getValue() || !nextBar.getValue())
                    .isTrue();
        }
    }
}
