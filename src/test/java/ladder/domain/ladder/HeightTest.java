package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HeightTest {
    @Test
    void 생성자_인풋_형식_오류_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Height("f");
        });
    }
    @Test
    void 플로어_잘_생성되는지_확인() {
        assertThat((new Height("6")).getFloor()).isEqualTo(6);
    }
}