package com.woowacourse.laddergame.util;

import java.util.Objects;

public class NaturalNumber {
    private int number;

    public NaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }

        this.number = number;
    }

    public int convertIndex() {
        return number - 1;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBiggerThan(NaturalNumber number) {
        return this.number > number.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NaturalNumber)) return false;
        NaturalNumber that = (NaturalNumber) o;
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
