package ladder.validator;

import java.util.List;

import ladder.domain.UserOutput;

public class Validator {
	public static void validateNamesLength(List<String> names) {
		if (!names.stream().allMatch(name -> name.length() <= 5)) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_NAMES.getOutputMessage());
		}
	}

	public static boolean validatePlayerNameAll(List<String> names) {
		if(names.stream().anyMatch(name -> name.equals(UserOutput.PRINT_ALL_PLAYER.getOutputMessage()))) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_NAME_ALL.getOutputMessage());
		}
		return true;
	}

	public static void validateNumber(String height) {
		try {
			Integer.parseInt(height);
		} catch (Exception e) {
			throw new NumberFormatException(UserOutput.VIOLATE_LADDER_HEIGHT.getOutputMessage());
		}
	}
}
