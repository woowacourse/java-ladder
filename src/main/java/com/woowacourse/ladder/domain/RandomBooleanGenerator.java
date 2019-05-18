package com.woowacourse.ladder.domain;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    @Override
    public boolean generateBoolean() {
        return new Random().nextBoolean();
    }
}
