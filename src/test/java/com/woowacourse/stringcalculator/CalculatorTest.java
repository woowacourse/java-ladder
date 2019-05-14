package com.woowacourse.stringcalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    void 더하기() {
    }

    @Test
    void 예외반환() {
        Calculator calculator = new Calculator();
        List<Integer> numbers = Arrays.asList(-2);
        assertThrows(IllegalArgumentException.class,() -> {
            calculator.add(numbers);
        });
    }

}
