package ladder.util;

import java.util.Arrays;
import java.util.List;

import ladder.domain.UserOutput;

public class StringSplitUtils {
	public static List<String> splitNames(String names) {
		if (org.apache.commons.lang3.StringUtils.isBlank(names)) {
			throw new NullPointerException(UserOutput.VIOLATE_PLAYER_NAME.getOutputMessage());
		}
		return Arrays.asList(names.split(","));
	}
}
