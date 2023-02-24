package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.player.Position;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PointTest {

    @Test
    void move_메서드를_이용해서_왼쪽으로_이동() {
        assertThat(Point.LEFT.move(Position.valueOf(1))).isEqualTo(Position.valueOf(0));
    }

    @Test
    void move_메서드를_이용해서_오른쪽으로_이동() {
        assertThat(Point.RIGHT.move(Position.valueOf(0))).isEqualTo(Position.valueOf(1));
    }

    @Test
    void move_메서드를_이용해서_이동하지_않음() {
        assertThat(Point.NONE.move(Position.valueOf(0))).isEqualTo(Position.valueOf(0));
    }
}
