package ladder.util;

import java.util.Random;

public class Util {
    public static boolean getRandomState() {
        return new Random().nextBoolean();
    }

    public static String formatName(String name) {
        return String.format("%6s", name);
    }
}
