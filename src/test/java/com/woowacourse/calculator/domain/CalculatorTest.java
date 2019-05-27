package com.woowacourse.calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
    @Test
    void 빈_문자열입력() {
        String input = "";

        assertThat(Calculator.sum(new CalculatorDto(input))).isEqualTo(0);
    }

    @Test
    void null_입력() {
        String input = null;

        assertThat(Calculator.sum(new CalculatorDto(input))).isEqualTo(0);
    }

    @Test
    void 숫자_하나_입력() {
        String input = "1";

        assertThat(Calculator.sum(new CalculatorDto(input))).isEqualTo(1);
    }

    @Test
    void 구분자로_계산() {
        String input = "1,2:3";

        assertThat(Calculator.sum(new CalculatorDto(input))).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_계산() {
        String input = "//;\n1;2;3";

        assertThat(Calculator.sum(new CalculatorDto(input))).isEqualTo(6);
    }

    @Test
    void 음수_입력_예외처리() {
        String input = "-1,2,3";

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            Calculator.sum(new CalculatorDto(input));
        }).withMessage("음수는 입력할 수 없습니다");
    }
}
