package ladder.util;

import java.util.Arrays;
import java.util.List;
import ladder.domain.ExceptionOutput;
import org.apache.commons.lang3.StringUtils;

public class StringSplitUtils {
	public static List<String> splitString(String input) {
		input = input.trim();
		if (input.isEmpty()) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_PLAYER_NAME_AND_REWARD_NAME.getOutputMessage());
		}
		if (StringUtils.isBlank(input)) {
			throw new NullPointerException(ExceptionOutput.VIOLATE_PLAYER_NAME_AND_REWARD_NAME.getOutputMessage());
		}

		return Arrays.asList(input.split(","));
	}
}
