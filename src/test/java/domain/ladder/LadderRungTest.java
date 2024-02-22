package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LadderRungTest {
    @Test
    void true면_연결된_가로대를_생성한다() {
        // given
        boolean isConnected = true;

        // when
        LadderRung ladderRung = LadderRung.findLadderRung(isConnected);

        // then
        assertThat(ladderRung).isEqualTo(LadderRung.CONNECTED);
    }

    @Test
    void false면_연결되지_않은_가로대를_생성한다() {
        // given
        boolean isConnected = false;

        // when
        LadderRung ladderRung = LadderRung.findLadderRung(isConnected);

        // then
        assertThat(ladderRung).isEqualTo(LadderRung.DISCONNECTED);
    }
}
