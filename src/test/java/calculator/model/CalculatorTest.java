/*
 * @(#)CalculatorTest.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */

package calculator.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
class CalculatorTest {
        /*문자열 계산기의 계산기에 대한 테스트*/
        @Test
        void 합() {
                assertThat(new Calculator(Arrays.asList(1, 2, 3)).sum()).isEqualTo(6);
        }

        @Test
        void 인풋없을때() {
                assertThat(new Calculator(Arrays.asList()).sum()).isEqualTo(0);
        }

        @Test
        void 숫자하나일때() {
                assertThat(new Calculator(Arrays.asList(2)).sum()).isEqualTo(2);
        }
}