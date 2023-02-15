package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        Assertions.assertThat(line.getBars()).isEqualTo(List.of(BarTest.FALSE, BarTest.FALSE, BarTest.FALSE, BarTest.FALSE));
    }

    @Test
    @DisplayName("addBars()은 랜덤 값이 true로 나올 때, 생성되는 bars")
    void test_2() {
        // when
        line.addBars(4, () -> true);

        // then
        Assertions.assertThat(line.getBars()).isEqualTo(List.of(BarTest.FALSE, BarTest.TRUE, BarTest.FALSE, BarTest.TRUE));
    }

//    @Test
//    @DisplayName("addRandom()은 랜덤값을 더해준다.")
//    void test_2() {
//        // given
//        Line line = new Line(4);
//
//        // when
//        line.addRandom(() -> true);
//
//        // then
//        Assertions.assertThat(line.getLine()).isEqualTo(List.of(false, true));
//    }
}
