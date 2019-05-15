package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 덧셈_테스트() {
        assertThat(calculator.add("")).isEqualTo(0);
        assertThat(calculator.add("1,1,1")).isEqualTo(3);
        assertThat(calculator.add("//a\n1a1a1")).isEqualTo(3);
        assertThat(calculator.add("//ab\n1ab1ab1")).isEqualTo(3);
        assertThat(calculator.add("//a\n//b\n1a1b1")).isEqualTo(3);
    }

    @Test
    void 기본_구분자_테스트() {
        assertThat(calculator.add("1:1")).isEqualTo(2);

    }

    @Test
    void 커스텀_구분자_테스트() {
        assertThat(calculator.makeRegex("//ab\n//c\n")).isEqualTo("[,]|[:]|[(ab)]|[(c)]");
    }

    @Test
    void 텍스트_필터링_테스트() {
        assertThat(calculator.textFilter("//adf\n1adf2adf3adf4")).isEqualTo("1adf2adf3adf4");
    }

    @Test
    void 음수를_넣었을_때_예외를_던지는지_테스트() {
        assertThrows(RuntimeException.class, () -> calculator.add("-1,1"));
    }

    @Test
    void 숫자_이외의_값을_넣었을_때_예외를_던지는지_테스트() {
        assertThrows(RuntimeException.class, () -> calculator.add("//a\nss,1"));
    }

    @Test
    void 커스텀_구분자가_숫자인_경우_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> calculator.checkRegex("12"));
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }
}
