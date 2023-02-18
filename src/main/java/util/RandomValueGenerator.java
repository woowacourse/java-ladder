package util;

import java.util.Random;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 18.
 */
public class RandomValueGenerator {

    private final Random random = new Random();

    public Boolean getRandomValue() {
        return random.nextBoolean();
    }
}
