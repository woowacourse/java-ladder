package ladder.util;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Rule {
    public static void ruleNamesMinSize(List<String> names) {
        if (names.size() <= Const.ZERO) {
            throw new IllegalArgumentException(Const.EX_PLAYER_COUNT);
        }
    }

    public static void ruleNameOverLength(String name) {
        if (StringUtils.isBlank(name) || name.length() > Const.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Const.EX_NAME);
        }
    }
}
