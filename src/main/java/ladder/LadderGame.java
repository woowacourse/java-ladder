package ladder;


import ladder.domain.Ladder;
import ladder.domain.LadderGameResult;
import ladder.util.StringSplitUtils;
import ladder.validator.Validator;
import ladder.view.InputView;

import java.util.*;

public class LadderGame {
	private static Ladder ladder;
	private static List<String> players = new ArrayList<>();


	public static LadderGameResult run(List<String> gameReward) {
		Map<String, String> gameResult = new HashMap<>();

		for(int i=0; i<players.size(); ++i) {
			gameResult.put(players.get(i), gameReward.get(ladder.getLastPosition(i)));
		}

		return new LadderGameResult(gameResult);
	}

	public static Ladder generatreLadder(final int ladderHeight) {
		ladder = new Ladder(players.size(), ladderHeight);
		return ladder;
	}

	public static List<String> getPersonNames() {
		String names;

		try {
			names = InputView.inputNames();
			Validator.validateNamesLength(StringSplitUtils.splitString(names));
			players = Arrays.asList(names.split(","));
			return players;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getPersonNames();
		}
	}

	public static int getLadderHeight() {
		String height;

		try {
			height = InputView.inputHeight();
			Validator.validateNumber(height);
			return Integer.parseInt(height);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getLadderHeight();
		}
	}

	public static List<String> getGameReward() {
		String result;

		try {
			result = InputView.inputResults();
			Validator.compareLength(players, StringSplitUtils.splitString(result));
			return Arrays.asList(result.split(","));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getGameReward();
		}
	}
}
