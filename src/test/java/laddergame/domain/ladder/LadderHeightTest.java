package laddergame.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderHeightTest {

    @Test
    public void 객체_생성_검사() {
        LadderHeight ladderHeight = LadderHeight.of(5);
        assertThat(ladderHeight).isEqualTo(LadderHeight.of(5));
    }

    @Test
    public void 숫자를_제대로_반환하는지_검사() {
        LadderHeight ladderHeight = LadderHeight.of(5);
        assertThat(ladderHeight.getLadderHeight()).isEqualTo(5);
    }

    @Test
    public void 음수로_생성했을떄_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LadderHeight.of(-1);
        });
    }

    @Test
    public void 숫자0으로_생성했을떄_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LadderHeight.of(0);
        });
    }
}
