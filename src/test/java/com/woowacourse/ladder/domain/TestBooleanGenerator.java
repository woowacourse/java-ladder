package com.woowacourse.ladder.domain;

import java.util.List;

public class TestBooleanGenerator implements BooleanGenerator {
    private final List<Boolean> bools;
    private int top;

    public TestBooleanGenerator(List<Boolean> boolsToReturn) {
        this.bools = boolsToReturn;
        top = 0;
    }

    @Override
    public boolean generateBoolean() {
        if (top >= bools.size()) {
            throw new IllegalStateException("Have no booleans to return");
        }
        return bools.get(top++);
    }
}
