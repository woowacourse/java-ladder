package domain;

import java.security.SecureRandom;

public class RandomLinkGenerator implements LinkGenerator {
    private static final SecureRandom secureRandom = new SecureRandom();

    @Override
    public Link generate() {
        return Link.from(secureRandom.nextBoolean());
    }
}
