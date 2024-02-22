package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.height.Height;
import org.junit.jupiter.api.Test;
import support.ConnectedLadderRungGenerator;

public class LadderTest {
    private final LadderRungGenerator ladderRungGenerator = new ConnectedLadderRungGenerator();

    @Test
    void 주어진_높이에_맞게_사다리를_생성한다() {
        // given
        Height height = new Height(5);
        int playerSize = 6;

        // when
        Ladder ladder = Ladder.create(height, playerSize, ladderRungGenerator);

        // then
        assertThat(ladder.getRows()).hasSize(height.getValue());
    }
}
