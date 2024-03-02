package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DirectionalPointTest {
    @Test
    void 가로대가_연결되면_방향은_오른쪽을_가리킨다() {
        // given
        final boolean isConnected = true;
        final DirectionalPoint ladderPoint = DirectionalPoint.findDirectionalPoint(isConnected);

        // when & then
        assertThat(ladderPoint).isEqualTo(DirectionalPoint.RIGHT);
    }

    @Test
    void 가로대가_연결되지_않으면_방향은_중앙을_가리킨다() {
        // given
        final boolean isConnected = false;
        final DirectionalPoint ladderPoint = DirectionalPoint.findDirectionalPoint(isConnected);

        // when & then
        assertThat(ladderPoint).isEqualTo(DirectionalPoint.STRAIGHT);
    }

    @Test
    void enum은_동일한_인스턴스를_반환한다() {
        final DirectionalPoint ladderPoint1 = DirectionalPoint.findDirectionalPoint(true);
        final DirectionalPoint ladderPoint2 = DirectionalPoint.findDirectionalPoint(true);

        assertEquals(ladderPoint1, ladderPoint2);
    }
}
