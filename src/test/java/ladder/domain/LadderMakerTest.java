package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderMakerTest {
    @Test
    void 사람이한명() {
        assertThat(LadderMaker.randomPoint(new ArrayList<>(), 1)).isFalse();
    }

    @Test
    void 이전값이_True() {
        assertThat(LadderMaker.randomPoint(Arrays.asList(false, true), 3)).isFalse();
    }
}
