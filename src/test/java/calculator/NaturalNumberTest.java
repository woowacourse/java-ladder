package calculator;

import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NaturalNumberTest {
    @Test
    void 합() {
        NaturalNumbers numbers = new NaturalNumbers(Arrays.asList(3,5,8));
        assertThat(numbers.sum()).isEqualTo(16);
    }
}
