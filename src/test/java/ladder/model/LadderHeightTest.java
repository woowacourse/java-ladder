package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderHeightTest {
    @Test
    void 높이_입력이_객체에_잘_들어갔는지_테스트() {
        assertThat(new LadderHeight(5).getHeight()).isEqualTo(5);
    }

    @Test
    void 높이가_기준치_이하의_수인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderHeight(0);
        });
    }
}
