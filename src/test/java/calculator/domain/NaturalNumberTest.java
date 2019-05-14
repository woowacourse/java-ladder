package calculator.domain;

import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NaturalNumberTest {
    @Test
    void 합() {
        Calculator numbers = new Calculator(Arrays.asList(3,5,8));
        assertThat(numbers.sum()).isEqualTo(16);
    }
}
