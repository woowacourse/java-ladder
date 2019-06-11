package ladderGameSolo;

import ladderGameSolo.domain.Height;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightTest {
    @Test
    void 높이() {
        Height height = new Height(4);
        assertThat(height.getHeight()).isEqualTo(4);
    }
}
