package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DirectionTest {
    @Test
    public void 첫번쨰_디렉션() {
        assertThat(Direction.first(false)).isEqualTo(new Direction(false, false));
    }

    @Test
    public void 마지막_디렉션() {
        assertThat(new Direction(false, true).last()).isEqualTo(Direction.of(true, false));
    }

    @Test
    public void 왼쪽_이동() {
        assertThat(new Direction(true, false).move()).isEqualTo(-1);
    }

    @Test
    public void 제자리_이동() {
        assertThat(new Direction(false, false).move()).isEqualTo(0);
    }

    @Test
    public void 오른쪽_이동() {
        assertThat(new Direction(false, true).move()).isEqualTo(1);
    }

    @Test
    public void 좌우_모두_디렉션_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Direction(true, true);
        });
    }
}
