package util;

import java.util.Random;

public class RandomTrueOrFalseGenerator implements TrueOrFalseGenerator {

    private static final Random random = new Random();
    @Override
    public  boolean generate() {
        return random.nextBoolean();
    }





}
