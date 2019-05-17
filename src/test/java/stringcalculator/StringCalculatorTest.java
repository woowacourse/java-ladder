package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    void 덧셈(){
        assertThat(new StringCalculator("1,2,0").addAll()).isEqualTo(3);
    }

    @Test
    void 음수_검사(){
        assertThrows(RuntimeException.class, () -> new StringCalculator("1,-2,3"));
    }
}
