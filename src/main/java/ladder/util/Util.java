package ladder.util;

import java.util.Random;

public class Util {
    public static boolean getRandomState() {
        return new Random().nextBoolean();
    }

    public static String formatAlignRight(String name) {
        return String.format("%6s", name);
    }

    public static String formatAlignLeft(String name) {
        return String.format("%-6s", name);
    }
}
