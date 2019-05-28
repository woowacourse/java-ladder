package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private final Ladder ladder = Ladder.from(Arrays.asList(
            HorizontalLine.from(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE)),
            HorizontalLine.from(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT))
    ));

    @Test
    void match_() {
        assertThat(ladder.match()).isEqualTo(LadderMatchingIndice.from(Arrays.asList(2, 0, 1)));
    }

    @Test
    void toString_() {
        assertThat(ladder.toString()).isEqualTo(
                        "     |-----|     |\n" +
                        "     |     |-----|\n");
    }

    @Test
    void create_높이_확인() {
        Height height = Height.create(10);
        int numPosition = 3;

        assertThat(Ladder.create(height, numPosition).getHeight()).isEqualTo(height);
    }

    @Test
    void create_너비_확인() {
        Height height = Height.create(10);
        int numPosition = 3;

        assertThat(Ladder.create(height, numPosition).getNumPosition()).isEqualTo(numPosition);
    }
}
