package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private int widthOfLadder;
    private Line line;

    @BeforeEach
    void setup() {
        widthOfLadder = 5;
        line = new Line(widthOfLadder, new MockRandomDataGenerator());
    }

    @Test
    @DisplayName("widthOfLadder 크기의 라인이 생성되는지 확인한다.")
    void generateLineSizeTest() {
        assertThat(line.getLine().size()).isEqualTo(widthOfLadder);
    }

    @RepeatedTest(100)
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


}
