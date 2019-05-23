package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    private StringCalculator cal;

    @BeforeEach
    public void setup() {
        cal = new StringCalculator();
    }

    @Test
    public void add_null_또는_빈문자() {
//      assertEquals(0, cal.add(null));
//      assertEquals(0, cal.add(""));
        assertThat(cal.add("")).isEqualTo(0);
        assertThat(cal.add(null)).isEqualTo(0);
    }

    @Test
    public void add_숫자하나() throws Exception {
//        assertEquals(1, cal.add("1"));
        assertThat(cal.add("1")).isEqualTo(1);
    }

    @Test
    public void add_쉼표구분자() throws Exception {
//        assertEquals(3, cal.add("1,2"));
        assertThat(cal.add("1,2")).isEqualTo(3);
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        assertThat(cal.add("1,2:3")).isEqualTo(6);
    }

    @Test
    public void add_custom_구분자() throws Exception {
        assertThat(cal.add("//;\n1;2;3")).isEqualTo(6);
    }

   /* @Test(expected = RuntimeException.class)
    public void add_negative() throws Exception {
        cal.add("-1,2,3");
    }*/

    @Test
    public void add_negative() throws Exception {
        assertThrows(RuntimeException.class, () -> {
            cal.add("-1,2,3");
        });
    }
}
