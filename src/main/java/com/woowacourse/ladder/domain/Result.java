package com.woowacourse.ladder.domain;

public class Result {
    private final String name;
    private final String result;

    public Result(final String name,final String result) {
        this.name = name;
        this.result = result;
    }

    @Override
    public String toString() {
        return name + ": " + result+"\n";
    }

    public String getResult() {
        return result;
    }
}
