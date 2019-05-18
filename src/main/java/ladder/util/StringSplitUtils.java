package ladder.util;

import ladder.domain.UserOutput;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class StringSplitUtils {
    public static List<String> splitString(String input) {
        if (StringUtils.isBlank(input)) {
            throw new NullPointerException(UserOutput.VIOLATE_PLAYER_NAME.getOutputMessage());
        }
        return Arrays.asList(input.split(","));
    }
}
