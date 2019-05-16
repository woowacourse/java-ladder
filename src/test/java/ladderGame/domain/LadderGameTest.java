package ladderGame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderGameTest {

    @Test
    void 사다리_높이_추가() {
        assertThat(new LadderGame(5, 4).getHeight()).isEqualTo(5);
    }

    @Test
    void 사다리_높이_음수일_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGame(-1, 4);
        });
    }

}
