package ladder.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomHelperTest {
    @Test
    void 사람이한명() {
        assertThat(RandomHelper.randomPoint(Arrays.asList(false, false), 1)).isFalse();
    }

    @Test
    void 이전값이_True() {
        assertThat(RandomHelper.randomPoint(Arrays.asList(false, true), 3)).isFalse();
    }
}
