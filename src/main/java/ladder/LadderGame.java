package ladder;

import ladder.domain.Ladder;
import ladder.domain.UserOutput;
import ladder.view.InputView;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class LadderGame {
	public static List<String> splitNames(String names) {
		if (StringUtils.isBlank(names)) {
			throw new NullPointerException(UserOutput.VIOLATE_PLAYER_NAME.getOutputMessage());
		}
		return Arrays.asList(names.split(","));
	}

	public Ladder run() {
		List<String> names = getPersonNames();
		int ladderHeight = getLadderHeight();

		return new Ladder(names.size(), ladderHeight);
	}

	private static List<String> getPersonNames() {
		String names;

		try {
			names = InputView.inputNames();
			Validator.checkNamesLength(splitNames(names));
			return Arrays.asList(names.split(","));
		} catch (Exception e) {
			return getPersonNames();
		}
	}

	private static int getLadderHeight() {
		String height;

		try {
			height = InputView.inputHeight();
			Validator.checkLadderHeight(height);
			return Integer.parseInt(height);
		} catch (Exception e) {
			return getLadderHeight();
		}
	}
}
