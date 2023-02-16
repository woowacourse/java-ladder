import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.FixedNumberGenerator;

public class LineTest {
    @DisplayName("생성한 값이 1이면 point가 생성된다.")
    @Test
    void shouldMakePoint() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(1);
        Assertions.assertThat(fixedNumberGenerator.isPoint()).isEqualTo(true);
    }

    @DisplayName("생성한 값이 0이면 point가 생성되지 않는다.")
    @Test
    void shouldNotMakePoint() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(0);
        Assertions.assertThat(fixedNumberGenerator.isPoint()).isEqualTo(false);
    }
}
