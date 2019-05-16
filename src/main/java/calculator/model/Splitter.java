/*
 * @(#)Splitter.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */

package calculator.model;

import calculator.constants.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0 2019년 05년 16일
 * @author 김효건
 */
public class Splitter {
    /*(입력 구분기) 주어진 입력에 대해 구분자와, 식을 추출하는 클래스*/
    private String delimiter = Constants.DEFAULT_DELIMITER;
    private String expression;

    public Splitter(String input) {
        this.expression = input;
        if (checkEmptyInput()) {
            return;
        }
        if (checkCustomExpression()) {
            return;
        }
        checkDefaultExpression();
    }

    private boolean checkEmptyInput() {
        if (expression.length() == 0) {
            this.expression = Constants.EMPTY_EXPRESSION;
            return true;
        }
        return false;
    }

    private boolean checkCustomExpression() {
        Matcher m = Pattern.compile(Constants.CUSTOM_DELIMITER_REGEX).matcher(expression);
        if (m.find()) {
            this.delimiter = m.group(1);
            this.expression = m.group(2);
            return true;
        }
        return false;
    }

    private void checkDefaultExpression() {
        StringTokenizer st = new StringTokenizer(expression, Constants.DEFAULT_DELIMITER);
        while (st.hasMoreTokens()) {
            Integer.valueOf(st.nextToken());
        }
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public List<Integer> getExpression() {
        List<Integer> numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression, this.delimiter);
        while (st.hasMoreTokens()) {
            numbers.add(Integer.valueOf(st.nextToken()));
        }
        return numbers;
    }

}