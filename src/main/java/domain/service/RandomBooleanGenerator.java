package domain.service;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {
    @Override
    public Boolean generate() {
        return new Random().nextBoolean();
    }
}
