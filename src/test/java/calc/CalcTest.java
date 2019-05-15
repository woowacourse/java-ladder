package calc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalcTest {
    @Test
    void nullTest() {
        assertThat(new Calc(null).getResult()).isEqualTo(0);
    }

    @Test
    void emptyTest() {
        assertThat(new Calc("").getResult()).isEqualTo(0);
    }

    @Test
    void blankTestA() {
        assertThat(new Calc(" ").getResult()).isEqualTo(0);
    }

    @Test
    void blankTestB() {
        assertThat(new Calc("   ").getResult()).isEqualTo(0);
    }

    @Test
    void singleNumberTest() {
        assertThat(new Calc("5").getResult()).isEqualTo(5);
    }

    @Test
    void splitCommaTest() {
        assertThat(new Calc("2,7").getResult()).isEqualTo(9);
    }

    @Test
    void splitCommaColonTest() {
        assertThat(new Calc("1,3:6").getResult()).isEqualTo(10);
    }

    @Test
    void splitCustomTest() {
        assertThat(new Calc("//;\n4;7,8").getResult()).isEqualTo(19);
    }

    @Test
    void negativeNumberTest() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            new Calc("-3,2,6");
        });
    }

    @Test
    void wrongInputTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calc(" a"));
    }
}