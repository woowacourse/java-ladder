package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderRungTest {
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 가로대가_연결되면_true를_반환하고_연결되지_않으면_false를_반환한다(boolean isConnected) {
        // given
        LadderRung ladderRung = LadderRung.findRung(isConnected);

        // when & then
        assertThat(ladderRung.isConnected()).isEqualTo(isConnected);
    }

    @Test
    void enum은_동일한_인스턴스를_반환한다() {
        final LadderRung rung1 = LadderRung.findRung(true);
        final LadderRung rung2 = LadderRung.findRung(true);

        assertEquals(rung1, rung2);
    }
}
