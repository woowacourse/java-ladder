package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderHeightTest {
    @Test
    void 생성자_인풋_형식_오류_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderHeight("f");
        });
    }

    @Test
    void 플로어_잘_생성되는지_확인() {
        assertThat((new LadderHeight("6")).getHeight()).isEqualTo(6);
    }

    @Test
    void 층수_0이하_입력_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderHeight("0");
        });
    }
}