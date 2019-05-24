package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void 첫번째_포인트_생성_후_왼쪽_방향_리턴() {
        assertThat(Point.first().getLeft()).isEqualTo(new Direction(false));
    }

    @Test
    void 마지막_포인트는_오른쪽으로_이동_불가능() {
        assertThat(Point.first().last().canMoveRight()).isEqualTo(false);
    }

    @Test
    void 첫번째_포인트는_왼쪽으로_이동_불가능() {
        assertThat(Point.first().canMoveLeft()).isEqualTo(false);
    }
}