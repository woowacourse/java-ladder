package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("addBars()은 랜덤 값이 false로 나오면, 존재하지 않는 Bar로 모두 채워진 bars가 나온다.")
    void test_1() {
        // when
        Line line = new Line(() -> false, 4);
    
        // then
        assertThat(line.getBars())
                .contains(BarTest.FALSE, BarTest.FALSE, BarTest.FALSE, BarTest.FALSE);
    }

    @Test
    @DisplayName("addBars()은 랜덤 값이 true로 나오면, 존재하지 않는 Bar와 존재하는 Bar가 번갈아가면서 채워진 bars가 나온다.")
    void test_2() {
        // when
        Line line = new Line(() -> true, 4);

        // then
        assertThat(line.getBars())
                .contains(BarTest.FALSE, BarTest.TRUE, BarTest.FALSE, BarTest.TRUE);
    }
}
