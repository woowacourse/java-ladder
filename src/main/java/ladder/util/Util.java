package ladder.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Util {
    public static boolean getRandomState() {
        return new Random().nextBoolean();
    }

    public static String formatName(String name) {
        return String.format("%6s", name);
    }

    public static String checkName(String inputName) {
        inputName = inputName.replaceAll(" ", "");
        isBlank(inputName);
        isNameOverSize(inputName);
        return inputName;
    }

    private static void isBlank(String inputName) {
        if (StringUtils.isBlank(inputName)) {
            throw new IllegalArgumentException(Const.EX_PLAYER_COUNT);
        }
    }

    private static void isNameOverSize(String inputName) {
        List<String> names = Arrays.asList(inputName.split(","));
        Rule.ruleNamesMinSize(names);
        for (String name : names) {
            Rule.ruleNameOverLength(name);
        }
    }

    public static int checkDepth(int depth) {
        if (depth < Const.MIN_LINE_COUNT) {
            throw new IllegalArgumentException(Const.EX_LINE_COUNT);
        }
        return depth;
    }
}
