package ladder;


import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Result;
import ladder.util.StringSplitUtils;
import ladder.view.InputView;

import java.util.*;

public class LadderGame {
	private static Ladder ladder;
	private static List<Player> players = new ArrayList<>();


	public static List<Result> run(List<String> gameReward) {
		List<Result> results = new ArrayList<>();

		for(int i=0; i<players.size(); ++i) {
			results.add(new Result(players.get(i), gameReward.get(ladder.getLastPosition(i))));
		}

		return results;
	}

	public static Ladder generatreLadder(final int ladderHeight) {
		ladder = new Ladder(players.size(), ladderHeight);
		return ladder;
	}

	public static List<Player> getPersonNames() {
		String names;

		try {
			names = InputView.inputNames();
			Validator.checkNamesLength(StringSplitUtils.splitString(names));
			return generatePlayers(Arrays.asList(names.split(",")));
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

	public static List<Player> generatePlayers(List<String> names) {
		for(int i = 0;i < names.size(); ++i) {
			players.add(new Player(names.get(i)));
		}
		return players;
	}
}
