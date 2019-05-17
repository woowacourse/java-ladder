package ladder.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Util {
    public static boolean getRandomState() {
        return new Random().nextBoolean();
    }

    public static String formatAlignRight(String name) {
        List<String> names = Arrays.asList(name.split(","));
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : names) {
            stringBuilder.append(String.format("%6s", s));
        }
        return stringBuilder.toString();
    }
}
