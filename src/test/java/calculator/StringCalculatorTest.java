package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void 빈_문자열_입력() {
        assertThat(calculator.process("")).isEqualTo(0);
    }

    @Test
    public void null_입력() {
        assertThat(calculator.process(null)).isEqualTo(0);
    }

    @Test
    public void 숫자_하나_입력() {
        assertThat(calculator.process("5")).isEqualTo(5);
    }

    @Test
    public void 구분자가_컴마() {
        assertThat(calculator.process("1,2,3")).isEqualTo(6);
    }

    @Test
    public void 구분자가_콜론() {
        assertThat(calculator.process("1:2:3")).isEqualTo(6);
    }

    @Test
    public void 구분자가_컴마_또는_콜론() {
        assertThat(calculator.process("1,2:3")).isEqualTo(6);
    }

    @Test
    public void 커스텀_구분자() {
        assertThat(calculator.process("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    public void 음수_입력() {
        assertThatThrownBy(() -> {
            calculator.process("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 문자_입력() {
        assertThatThrownBy(() -> {
            calculator.process("a,b,c,3");
        }).isInstanceOf(RuntimeException.class);
    }
}
