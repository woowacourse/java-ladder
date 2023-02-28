package laddergame.domain;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomLinkGenerator implements LinkGenerator {

    public static final Random random;

    static {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("랜덤 객체를 생성할 수 없습니다.");
        }
    }

    @Override
    public Link pick() {
        return Link.from(random.nextBoolean());
    }
}
