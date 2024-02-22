package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;
import support.ConnectedLadderRungGenerator;

public class LadderRowTest {
    private final LadderRungGenerator ladderRungGenerator = new ConnectedLadderRungGenerator();

    @Test
    void 플레이어_수만큼_가로대를_생성한다() {
        // given
        final int playerSize = 5;

        // when
        LadderRow ladderRow = LadderRow.create(playerSize, ladderRungGenerator);

        // then
        assertThat(ladderRow.getRungs()).hasSize(playerSize);
    }

    @Test
    void 이전_가로대가_연결되어_있으면_가로대를_연속해서_놓을_수_없다() {
        // given
        final int playerSize = 4;

        // when
        LadderRow ladderRow = LadderRow.create(playerSize, ladderRungGenerator);

        // then
        List<LadderRung> rungs = ladderRow.getRungs();
        assertAll(
                () -> assertThat(rungs.get(0).isConnected()).isTrue(),
                () -> assertThat(rungs.get(1).isConnected()).isFalse(),
                () -> assertThat(rungs.get(2).isConnected()).isTrue(),
                () -> assertThat(rungs.get(3).isConnected()).isFalse()
        );
    }
}
