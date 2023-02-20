package domain.ladder;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.FixedNumberGenerator;

public class LineTest {
    @DisplayName("생성한 값이 1이면 움직일 수 있다.")
    @Test
    void shouldSuccessMovable() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(1);
        Assertions.assertThat(fixedNumberGenerator.isMovable()).isEqualTo(true);
    }

    @DisplayName("생성한 값이 0이면 움직일 수 없다.")
    @Test
    void shouldSuccessNotMovable() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(0);
        Assertions.assertThat(fixedNumberGenerator.isMovable()).isEqualTo(false);
    }

    @DisplayName("라인 생성 확인 테스트")
    @Test
    void shouldSuccessLine() {
        assertDoesNotThrow(() -> new Line(4));
    }
}
