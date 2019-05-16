package ladder;


import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.util.StringSplitUtils;
import ladder.view.InputView;

import java.util.*;

public class LadderGame {
	private static Ladder ladder;
	private static List<Player> list = new ArrayList<>();

	public static Ladder generatreLadder(List<String> names, int ladderHeight) {
		ladder = new Ladder(names.size(), ladderHeight);
		return ladder;
	}

	public static List<String> getPersonNames() {
		String names;

		try {
			names = InputView.inputNames();
			Validator.checkNamesLength(StringSplitUtils.splitString(names));
			return Arrays.asList(names.split(","));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getPersonNames();
		}
	}

	public static int getLadderHeight() {
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

	public static List<String> getGameResult(List<String> names) {
		String result;

		try {
			result = InputView.inputResults();
			Validator.checkNumberOfResult(names, StringSplitUtils.splitString(result));
			return Arrays.asList(result.split(","));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getGameResult(names);
		}
	}

	public static List<Player> generatePlayers(List<String> names) {
		int position = 0;

		for(String name : names) {
			list.add(new Player(name, position, ladder.getLastPosition(position)));
			position++;
		}

		return list;
	}
}
