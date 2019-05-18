package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DirectionTest {
    private static boolean TRUE = true;
    private static boolean FALSE = false;

    @Test
    void 각_포지션에서_방향_확인() {
        Direction direction = new Direction(FALSE, TRUE);
        assertThat(direction).isEqualTo(new Direction(FALSE, TRUE));
    }

    @Test
    void 방향이_한개가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Direction(TRUE, TRUE);
        });
    }

    @Test
    void 첫번째_라인에서_생성되는_경우() {
        assertThat(Direction.first(TRUE)).isEqualTo(new Direction(FALSE, TRUE));
        assertThat(Direction.first(FALSE)).isEqualTo(new Direction(FALSE, FALSE));
    }

    @Test
    void 마지막_라인에서_생성되는_경우() {
        assertThat(Direction.last(TRUE)).isEqualTo(new Direction(TRUE, FALSE));
        assertThat(Direction.last(FALSE)).isEqualTo(new Direction(FALSE, FALSE));
    }

    @Test
    void 이전_방향이_오른쪽인_경우_다음_방향_생성() {
        Direction direction = Direction.of(FALSE, TRUE).next(TRUE);
        assertThat(direction).isEqualTo(new Direction(TRUE, FALSE));

        direction = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(direction).isEqualTo(new Direction(TRUE, FALSE));
    }

    @Test
    void 이전_방향이_왼쪽인_경우_다음_방향_생성() {
        Direction direction = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(direction).isEqualTo(new Direction(FALSE, TRUE));

        direction = Direction.of(TRUE, FALSE).next(FALSE);
        assertThat(direction).isEqualTo(new Direction(FALSE, FALSE));
    }

    @Test
    void 이전_방향이_존재하지_않는_경우_다음_방향_생성() {
        Direction direction = Direction.of(FALSE, FALSE).next(TRUE);
        assertThat(direction).isEqualTo(new Direction(FALSE, TRUE));

        direction = Direction.of(FALSE, FALSE).next(FALSE);
        assertThat(direction).isEqualTo(new Direction(FALSE, FALSE));
    }

    @Test
    void 왼쪽으로_움직이는_경우() {
        assertThat(Direction.of(TRUE, FALSE).move()).isEqualTo(-1);
    }

    @Test
    void 오른쪽으로_움직이는_경우() {
        assertThat(Direction.of(FALSE, TRUE).move()).isEqualTo(1);
    }

    @Test
    void 움직이지_앟는_경우() {
        assertThat(Direction.of(FALSE, FALSE).move()).isEqualTo(0);
    }
}
