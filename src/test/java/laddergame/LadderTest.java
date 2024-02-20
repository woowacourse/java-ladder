package laddergame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import laddergame.domain.Ladder;
import laddergame.domain.LadderHeight;
import laddergame.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리를 생성한다.")
    @Test
    void createLadder() {
        // given
        final LadderHeight height = new LadderHeight(5);
        final Names names = new Names(List.of("pobi", "zeze"));

        // when
        Ladder ladder = Ladder.create(height, names);

        // then
        assertThat(ladder.getHeight()).isEqualTo(height.getHeight());
    }
}
