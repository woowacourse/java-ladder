package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line();
    }

    @Test
    @DisplayName("addBars()은 랜덤 값이 false로 나오면, 존재하지 않는 Bar로 모두 채워진 bars가 나온다.")
    void test_1() {
        // when
        line.addBars(4, () -> false);

        // then
        assertThat(line.getBars())
                .contains(BarTest.FALSE, BarTest.FALSE, BarTest.FALSE, BarTest.FALSE);
    }

    @Test
    @DisplayName("addBars()은 랜덤 값이 true로 나오면, 존재하지 않는 Bar와 존재하는 Bar가 번갈아가면서 채워진 bars가 나온다.")
    void test_2() {
        // when
        line.addBars(4, () -> true);

        // then
        assertThat(line.getBars())
                .contains(BarTest.FALSE, BarTest.TRUE, BarTest.FALSE, BarTest.TRUE);
    }
}
