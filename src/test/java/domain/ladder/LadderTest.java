package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.height.Height;
import org.junit.jupiter.api.Test;
import support.ConnectedLadderRungGenerator;

public class LadderTest {
    private final LadderRungGenerator trueGenerator = new ConnectedLadderRungGenerator();

    @Test
    void 주어진_높이에_맞게_사다리가_생성된다() {
        // given
        Height height = new Height(5);
        int playerSize = 5;

        // when
        Ladder ladder = Ladder.create(height, playerSize, trueGenerator);

        // then
        assertThat(ladder.getHeight()).isEqualTo(height.getValue());
    }
}
