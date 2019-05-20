package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderHeightTest {
    @Test
    public void 입력된_사다리_높이가_자연수가_아닐_때() {
        assertThatThrownBy(() -> new LadderHeight(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LadderHeight(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void isSmallerThanHeight() {
        LadderHeight height = new LadderHeight(3);
        assertThat(height.isSmallerThanHeight(2)).isTrue();
        assertThat(height.isSmallerThanHeight(4)).isFalse();
    }
}
