package com.woowacourse.ladder.domain;

import java.util.List;

public class TestBooleanGenerator implements BooleanGenerator {

    private final List<Boolean> booleans;
    private int current;

    TestBooleanGenerator(List<Boolean> booleans) {
        this.booleans = booleans;
        current = -1;
    }

    @Override
    public boolean generateBoolean() {
        return booleans.get(++current);
    }
}
