package util;

import java.util.Random;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class RandomValueGenerator {

    private final Random random = new Random();

    public boolean generate() {
        return random.nextBoolean();
    }
}
