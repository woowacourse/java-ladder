package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightTest {

    @Test
    public void 사다리_높이_정상_생성() {
        Height height = new Height("5");
        assertThat(new Height("5")).isEqualTo(height);
    }

    @Test (expected = IllegalArgumentException.class)
    public void 사다리_높이_음수_예외() {
        new Height("-1");
    }

    @Test (expected = IllegalArgumentException.class)
    public void 사다리_높이_최소값보다_작은_값_예외() {
        new Height("0");
    }
}
