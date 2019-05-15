package com.woowacourse.ladder.domain;

import com.woowacourse.ladder.interfaces.BooleanGenerator;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {
    @Override
    public boolean generateBoolean() {
        return new Random().nextBoolean();
    }
}
