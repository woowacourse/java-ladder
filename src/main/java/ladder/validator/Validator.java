package ladder.validator;

import java.util.List;

import ladder.domain.UserOutput;

public class Validator {
	private static boolean validateNameLength(String name) {
		return name.length() <= 5;
	}

	public static void validateNamesLength(List<String> names) {
		if (!names.stream().allMatch(name -> validateNameLength(name))) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_NAMES.getOutputMessage());
		}
	}

	public static void validateNumber(String height) {
		try {
			Integer.parseInt(height);
		} catch (Exception e) {
			throw new NumberFormatException(UserOutput.VIOLATE_LADDER_HEIGHT.getOutputMessage());
		}
	}

	public static void compareLength(List<String> playersNames, List<String> results) {
		if (playersNames.size() != results.size()) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_GAME_RESULTS.getOutputMessage());
		}
	}
}
