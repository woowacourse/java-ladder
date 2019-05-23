/*
 * @(#)Calculator.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
package calculator.model;

import java.util.List;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class Calculator {
        /*덧셈을 수행하는 클래스*/
        private List<Integer> numbers;

        public Calculator(List<Integer> numbers) {
                this.numbers = numbers;
        }

        public int sum() {
                int sum = 0;
                for (Integer number : numbers) {
                        sum += number;
                }
                return sum;
        }
}
