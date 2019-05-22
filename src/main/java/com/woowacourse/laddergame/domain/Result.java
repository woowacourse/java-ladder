package com.woowacourse.laddergame.domain;

import java.util.Objects;

public class Result {
    private String result;

    public Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return String.format("%-6.6s", result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result1 = (Result) o;
        return Objects.equals(getResult(), result1.getResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult());
    }
}
