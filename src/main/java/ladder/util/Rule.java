package ladder.util;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Rule {
    public static String rulePlayerNameLength(String name) {
        if (StringUtils.isBlank(name) || name.length() > Const.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Const.EX_NAME);
        }
        return name;
    }

    public static List<String> rulePlayerCountSize(List<String> names) {
        if (names.size() <= Const.MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(Const.EX_PLAYER_COUNT);
        }
        return names;
    }

    public static int rulePlayerCountSize(int playerCount) {
        if (playerCount < Const.MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(Const.EX_PLAYER_COUNT);
        }
        return playerCount;
    }

    public static int ruleLadderDepthRange(int depth) {
        if (depth < Const.MIN_LINE_COUNT) {
            throw new IllegalArgumentException(Const.EX_LINE_COUNT);
        }
        return depth;
    }
}
