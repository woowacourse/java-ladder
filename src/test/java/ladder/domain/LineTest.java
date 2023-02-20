package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line();
    }

    @Test
    @DisplayName("addBars()은 랜덤 값이 false로 나올 때, 생성되는 bars")
    void test_1() {
        // when
        line.addBars(4, () -> false);

        // then
        assertThat(line.getBars()).isEqualTo(List.of(BarTest.FALSE, BarTest.FALSE, BarTest.FALSE, BarTest.FALSE));
    }

    @Test
    @DisplayName("addBars()은 랜덤 값이 true로 나올 때, 생성되는 bars")
    void test_2() {
        // when
        line.addBars(4, () -> true);

        // then
        assertThat(line.getBars()).isEqualTo(List.of(BarTest.FALSE, BarTest.TRUE, BarTest.FALSE, BarTest.TRUE));
    }
}
