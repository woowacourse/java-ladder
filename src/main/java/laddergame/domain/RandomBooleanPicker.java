package laddergame.domain;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomBooleanPicker implements PickStrategy {

    public static final Random random;

    static {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean pick() {
        return random.nextBoolean();
    }
}
