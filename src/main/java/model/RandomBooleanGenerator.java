package model;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    @Override
    public boolean generator() {
        return new Random().nextBoolean();
    }
}
