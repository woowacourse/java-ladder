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
        return isNameRuleOK(isBlank(inputName.replaceAll(" ", "")));
    }

    private static String isBlank(String inputName) {
        if (StringUtils.isBlank(inputName)) {
            throw new IllegalArgumentException(Const.EX_PLAYER_COUNT);
        }
        return inputName;
    }

    private static String isNameRuleOK(String inputName) {
        List<String> names = Arrays.asList(inputName.split(","));
        Rule.rulePlayerCountSize(names);
        for (String name : names) {
            Rule.rulePlayerNameLength(name);
        }
        return inputName;
    }

    public static int checkDepth(int depth) {
        return Rule.ruleLadderDepthRange(depth);
    }
}
