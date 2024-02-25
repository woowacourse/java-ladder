package model;

import java.util.Random;

public class BooleanGenerator {

    public boolean generateBoolean() {
        return new Random().nextBoolean();
    }

    public boolean updateFalseIfTrue(boolean isTrue) {
        if (isTrue) {
            return false;
        }
        return new Random().nextBoolean();
    }
}
