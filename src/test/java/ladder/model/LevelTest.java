package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LevelTest {
    @Test
    void levelCreateTestNeverDraw() {
        Possible never = new Never();
        assertThat(new Level(4, never).getLines()).isEqualTo(Arrays.asList());
    }

    @Test
    void levelCreateTestAlwaysDraw() {
        Possible always = new Always();
        assertThat(new Level(11, always).getLines()).isEqualTo(Arrays.asList(0, 2, 4, 6, 8, 10));
    }

    @Test
    void levelCreateTestDrawOdd() {
        Possible oddOnly = new OddOnly();
        assertThat(new Level(13, oddOnly).getLines()).isEqualTo(Arrays.asList(0, 3, 6, 9, 12));
    }

    @Test
    void levelCreateTestDrawEven() {
        Possible evenOnly = new EvenOnly();
        assertThat(new Level(23, evenOnly).getLines()).isEqualTo(Arrays.asList(1, 4, 7, 10, 13, 16, 19, 22));
    }
}