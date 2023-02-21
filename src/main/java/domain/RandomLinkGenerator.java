package domain;

import java.security.SecureRandom;

public class RandomLinkGenerator implements LinkGenerator {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    @Override
    public Link generate() {
        return Link.from(SECURE_RANDOM.nextBoolean());
    }
}
