package stringAdder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stringAdder.StringCalculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @Test
    void 빈문자열이거나_공백() {
        assertThat(StringCalculator.addAll("")).isEqualTo(0);
        assertThat(StringCalculator.addAll(null)).isEqualTo(0);
    }

    @Test
    void 단일문자() {
        assertThat(StringCalculator.addAll("1")).isEqualTo(1);
    }

    @Test
    void 쉼표_구분() {
        assertThat(StringCalculator.addAll("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론_구분() {
        assertThat(StringCalculator.addAll("1:2")).isEqualTo(3);
    }

    @Test
    void 쉼표_콜론_구분() {
        assertThat(StringCalculator.addAll("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분() {
        assertThat(StringCalculator.addAll("//a\n1a2a3")).isEqualTo(6);
        assertThat(StringCalculator.addAll("//,\n1,2,3")).isEqualTo(6);
    }

    @Test
    void 음수가_포함된_경우() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            StringCalculator.addAll("-1,2,3");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            StringCalculator.addAll("//,\n-1,2,3");
        });
    }

    @Test
    void 문자가_포함된_경우() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            StringCalculator.addAll("a,b,c");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            StringCalculator.addAll("//,\na,b,c");
        });
    }
}
