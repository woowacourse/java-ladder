package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DirectionalRungTest {
    @Test
    void 가로대가_연결되면_방향은_오른쪽을_가리킨다() {
        // given
        final boolean isConnected = true;
        final DirectionalRung rung = DirectionalRung.findRung(isConnected);

        // when & then
        assertThat(rung).isEqualTo(DirectionalRung.RIGHT);
    }

    @Test
    void 가로대가_연결되지_않으면_방향은_중앙을_가리킨다() {
        // given
        final boolean isConnected = false;
        final DirectionalRung rung = DirectionalRung.findRung(isConnected);

        // when & then
        assertThat(rung).isEqualTo(DirectionalRung.MID);
    }

    @Test
    void enum은_동일한_인스턴스를_반환한다() {
        final DirectionalRung rung1 = DirectionalRung.findRung(true);
        final DirectionalRung rung2 = DirectionalRung.findRung(true);

        assertEquals(rung1, rung2);
    }
}
