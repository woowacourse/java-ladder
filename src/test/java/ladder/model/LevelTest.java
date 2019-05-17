package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LevelTest {
    @Test
    void levelCreateTestNeverDraw() {
        assertThat(new Level(4, new Never()).getVerticalLines()).isEqualTo(Arrays.asList());
    }

    @Test
    void levelCreateTestAlwaysDraw() {
        assertThat(new Level(11, new Always()).getVerticalLines()).isEqualTo(Arrays.asList(0, 2, 4, 6, 8, 10));
    }

    @Test
    void levelCreateTestDrawOdd() {
        assertThat(new Level(13, new OddOnly()).getVerticalLines()).isEqualTo(Arrays.asList(0, 3, 6, 9, 12));
    }

    @Test
    void levelCreateTestDrawEven() {
        assertThat(new Level(23, new EvenOnly()).getVerticalLines()).isEqualTo(Arrays.asList(1, 4, 7, 10, 13, 16, 19, 22));
    }
}