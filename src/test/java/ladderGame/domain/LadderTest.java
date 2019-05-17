package ladderGame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {

    @Test
    void 사다리_높이_추가() {
        assertThat(new Ladder(5, 4).getLadderHeight()).isEqualTo(5);
    }

    @Test
    void 사다리_높이_음수일_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(-1, 4);
        });
    }

}
