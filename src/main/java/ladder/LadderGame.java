package ladder;

import ladder.domain.Ladder;
import ladder.util.StringSplitUtils;
import ladder.view.InputView;

import java.util.Arrays;
import java.util.List;

public class LadderGame {
	public Ladder run() {
		List<String> names = getPersonNames();
		int ladderHeight = getLadderHeight();

		return new Ladder(names.size(), ladderHeight);
	}

	private static List<String> getPersonNames() {
		String names;

		try {
			names = InputView.inputNames();
			Validator.checkNamesLength(StringSplitUtils.splitNames(names));
			return Arrays.asList(names.split(","));
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
			System.out.println(e.getMessage());
			return getLadderHeight();
		}
	}
}
