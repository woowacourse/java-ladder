package ladder.domain.generator;

import java.security.SecureRandom;

public class RandomPointGenerator implements PointGenerator {

    private static final SecureRandom secureRandom = new SecureRandom();

    @Override
    public boolean generate() {
        return secureRandom.nextBoolean();
    }
}
