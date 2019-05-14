package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 쉼표로_문자열_구분하기() {
        assertThat(calculator.splitString("1,2,3")).isEqualTo(new String[] {"1", "2", "3"});
    }

    @Test
    void 콜론으로_문자열_구분하기() {
        assertThat(calculator.splitString("1:2:3")).isEqualTo(new String[] {"1", "2", "3"});
    }

    @Test
    void 쉼표와_콜론으로_문자열_구분하기() {
        assertThat(calculator.splitString("1:2,3")).isEqualTo(new String[] {"1", "2", "3"});
    }

    @Test
    void 커스텀_구분자로_문자열_구분하기() {
        assertThat(calculator.splitString("//#\n1#2#3")).isEqualTo(new String[] {"1", "2", "3"});
    }

    @Test
    void 쉼표와_콜론과_커스텀_구분자로_문자열_구분하기() {
        assertThat(calculator.splitString("//#\n1#2,3:4")).isEqualTo(new String[] {"1", "2", "3", "4"});
    }
}
