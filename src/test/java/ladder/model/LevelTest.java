package ladder.model;

import ladder.model.coin.Always;
import ladder.model.coin.EvenOnly;
import ladder.model.coin.Never;
import ladder.model.coin.OddOnly;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LevelTest {
    @Test
    void levelCreateTestNeverDraw() {
        assertThat(new Level(4, new Never()).getLines()).isEqualTo(Arrays.asList());
    }

    @Test
    void levelCreateTestAlwaysDraw() {
        assertThat(new Level(11, new Always()).getLines()).isEqualTo(Arrays.asList(0, 2, 4, 6, 8, 10));
    }

    @Test
    void levelCreateTestDrawOdd() {
        assertThat(new Level(13, new OddOnly()).getLines()).isEqualTo(Arrays.asList(0, 3, 6, 9, 12));
    }

    @Test
    void levelCreateTestDrawEven() {
        assertThat(new Level(23, new EvenOnly()).getLines()).isEqualTo(Arrays.asList(1, 4, 7, 10, 13, 16, 19, 22));
    }
}