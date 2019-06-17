package calc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalcTest {
    @Test
    void nullTest() {
        assertThat(Calc.sum(null)).isEqualTo(0);
    }

    @Test
    void emptyTest() {
        assertThat(Calc.sum("")).isEqualTo(0);
    }

    @Test
    void blankTest() {
        assertThat(Calc.sum(" ")).isEqualTo(0);
        assertThat(Calc.sum("   ")).isEqualTo(0);
    }

    @Test
    void singleNumberTest() {
        assertThat(Calc.sum("5")).isEqualTo(5);
    }

    @Test
    void splitCommaTest() {
        assertThat(Calc.sum("2,7")).isEqualTo(9);
    }

    @Test
    void splitCommaColonTest() {
        assertThat(Calc.sum("1,3:6")).isEqualTo(10);
    }

    @Test
    void splitCustomTest() {
        assertThat(Calc.sum("//;\n4;7,8")).isEqualTo(19);
    }

    @Test
    void negativeNumberTest() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            Calc.sum("-3,2,6");
        });
    }

    @Test
    void wrongInputTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calc.sum(" a"));
    }
}