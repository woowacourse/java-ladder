package com.woowacourse.ladder.domain;

public class ResultGenerator {
    public static Result generateResult(String name, String result) {
        return new Result(name, result);
    }
}
