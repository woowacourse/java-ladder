package ladder;

import java.util.List;

import ladder.domain.UserOutput;

public class Validator {
	private static boolean checkNameLength(String name) {
		return name.length() <= 5;
	}

	public static void checkNamesLength(List<String> names) {
		if (!names.stream().allMatch(name -> checkNameLength(name))) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_NAMES.getOutputMessage());
		}
	}

	public static void checkLadderHeight(String height) {
		try {
			Integer.parseInt(height);
		} catch (Exception e) {
			throw new NumberFormatException(UserOutput.VIOLATE_LADDER_HEIGHT.getOutputMessage());
		}
	}
}
