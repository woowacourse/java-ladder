package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {
    @Test
    void 숫자_추출하기() {
        assertThat(Numbers.getFromString("//;\n1;4;9", Delimiter.getDelimiterFromString("//;\n1;4;9"))).isEqualTo(Arrays.asList(1, 4, 9));
    }

    @Test
    void 디폴트_숫자_추출하기() {
        assertThat(Numbers.getFromString("1,4:9", ":|,")).isEqualTo(Arrays.asList(1, 4, 9));
    }
}
