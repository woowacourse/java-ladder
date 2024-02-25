package model;

import java.util.Random;

public class LadderRowElementGenerator implements BooleanGenerator{

    @Override
    public boolean updateFalseIfTrue(boolean isTrue) {
        if (isTrue) {
            return false;
        }
        return new Random().nextBoolean();
    }
}
