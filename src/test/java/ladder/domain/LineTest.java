package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LineTest {
    private int widthOfLadder;
    private Line line;

    /**
     * true,false,true,false
     */
    @BeforeEach
    void setup() {
        widthOfLadder = 4;
        line = Line.of(widthOfLadder, new MockRandomBarGenerator());
    }

    @Test
    @DisplayName("widthOfLadder 크기의 라인이 생성되는지 확인한다.")
    void generateLineSizeTest() {
        assertThat(line.getLine().size()).isEqualTo(widthOfLadder);
    }

    @Test
    @DisplayName("생성된 Line의 가로가 겹치지 않는지 확인한다.")
    void generateLineTest() {

        List<Bar> bars = line.getLine();

        for (int idx = 0; idx < bars.size() - 1; idx++) {
            Bar currentBar = bars.get(idx);
            Bar nextBar = bars.get(idx + 1);

            assertThat(!currentBar.getValue() || !nextBar.getValue())
                    .isTrue();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,-1", "2,1", "3,-1", "4,0"})
    @DisplayName("생성된 Line에서, 특정 위치의 Bar이 어디로 이동하는지 확인한다")
    void findNextMovingOfTest(int startIndex, int nextMoving) {
        assertThat(line.findNextMovingOf(startIndex))
                .isEqualTo(nextMoving);
    }
}
