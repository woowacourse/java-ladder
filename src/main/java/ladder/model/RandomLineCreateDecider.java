package ladder.model;

import java.security.SecureRandom;

public class RandomLineCreateDecider implements LineCreateDecider {

    private static final int MAX_RANDOM_INT = 2;
    private static final SecureRandom secureRandom = new SecureRandom();

    @Override
    public boolean decide() {
        int number = secureRandom.nextInt(MAX_RANDOM_INT);
        return number >= MAX_RANDOM_INT / 2;
    }
}
