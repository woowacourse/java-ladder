package cal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringPlusCalculatorTest {
    @Test
    void 덧셈() {
        int result = StringPlusCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
        result = StringPlusCalculator.calculate("1,3");
        assertThat(result).isEqualTo(4);
    }

    @Test
    void 콜론_구분자_덧셈() {
        int result = StringPlusCalculator.calculate("1:2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 쉼표_콜론_구분자_덧셈() {
        int result = StringPlusCalculator.calculate("1:2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_덧셈() {
        int result = StringPlusCalculator.calculate("//*\n1*2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 숫자_이외의_값_덧셈(){
        assertThrows(RuntimeException.class, () -> {
            StringPlusCalculator.calculate("a,b,c");
        });
    }

    @Test
    void 음수_예외_처리() {
        assertThrows(RuntimeException.class, () -> {
            StringPlusCalculator.calculate("-1,2");
        });
    }
}
