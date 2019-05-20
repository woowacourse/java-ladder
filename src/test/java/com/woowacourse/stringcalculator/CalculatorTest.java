package com.woowacourse.stringcalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    void 더하기() {
        assertThat(Calculator.add(Arrays.asList(2,3))).isEqualTo(5);
        assertThat(Calculator.add(Arrays.asList(2,3,5,6))).isEqualTo(16);
    }

    @Test
    void 음수를_전달할경우_예외반환() {
        Calculator calculator = new Calculator();
        List<Integer> numbers = Arrays.asList(-2);
        assertThrows(IllegalArgumentException.class,() -> {
            calculator.add(numbers);
        });
    }

}
