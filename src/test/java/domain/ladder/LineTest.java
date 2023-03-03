package domain.ladder;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.FixedBooleanGenerator;
import utils.RandomBooleanGenerator;
import view.LineStatus;

public class LineTest {
    @DisplayName("생성한 값이 1이면 움직일 수 있다.")
    @Test
    void shouldSuccessMovable() {
        FixedBooleanGenerator fixedBooleanGenerator = new FixedBooleanGenerator(true);
        Assertions.assertThat(LineStatus.printStatus(fixedBooleanGenerator.isMovable(), 1)).isEqualTo("-");
    }

    @DisplayName("생성한 값이 0이면 움직일 수 없다.")
    @Test
    void shouldSuccessNotMovable() {
        FixedBooleanGenerator fixedBooleanGenerator = new FixedBooleanGenerator(false);
        Assertions.assertThat(LineStatus.printStatus(fixedBooleanGenerator.isMovable(), 1)).isEqualTo(" ");
    }

    @DisplayName("라인 생성 확인 테스트")
    @Test
    void shouldSuccessLine() {
        assertDoesNotThrow(() -> new Line(4, new RandomBooleanGenerator()));
    }
}
