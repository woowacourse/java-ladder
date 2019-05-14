package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {
    @Test
    void 숫자_추출하기() {
        assertThat(Numbers.getFromString("//;\n1;4;9", Delimiter.getFromString("//;\n1;4;9"))).isEqualTo(Arrays.asList(1, 4, 9));
    }
}
