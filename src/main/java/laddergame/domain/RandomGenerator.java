package laddergame.domain;

import java.util.Random;

public class RandomGenerator {
    public static int generateNumber(int bound) {
        return new Random().nextInt(bound) + 1;
    }
}
