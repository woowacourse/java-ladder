package ladder;


import ladder.domain.Ladder;
import ladder.domain.LadderGameBoard;
import ladder.domain.Player;
import ladder.util.StringSplitUtils;
import ladder.view.InputView;

import java.util.*;

public class LadderGame {
	private static Ladder ladder;
	private static List<String> names;
	private static List<String> results;
	private static int height;
	private static List<Player> players;

	public static LadderGameBoard generateGameBoard() {
		names = getPersonNames();
		results = getGameResult(names);
		height = getLadderHeight();
		ladder = new Ladder(results.size(), height);

		return new LadderGameBoard(names, results, ladder);
	}

	private static List<String> getPersonNames() {
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

	private static List<String> getGameResult(List<String> names) {
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
	    players = new ArrayList<>();
		int position = 0;

		for(String name : names) {
			players.add(new Player(name, position));
			position ++;
		}
		return players;
	}

	public static String getNameForResult(List<String> names) {
		String name;

		try {
			name = InputView.inputNameForResult();
			Validator.checkNameForResult(names, name);
			return name;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getNameForResult(names);
		}
	}

	public static void matchPlayerAndResult(List<Player> players) {
	    for (Player player : players) {
            ladder.goDownLadder(player);
        }
    }
}
