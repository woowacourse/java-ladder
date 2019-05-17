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

	private static List<Player> players = new ArrayList<>();;

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

	public static void executeLadderGame() {
	    List<Player> players = generatePlayers(names);
	    movePlayers(players);
    }

	private static List<Player> generatePlayers(List<String> names) {
		int position = 0;

		for(String name : names) {
			players.add(new Player(name, position));
			position ++;
		}
		return players;
	}

	private static void movePlayers(List<Player> players) {
	    for (Player player : players) {
            ladder.goDownLadder(player);
        }
    }

    public static List<Player> lookUpResult() {
        String input;

        do {
            input = getNameForResult(names);
            return getPlayersForResult(input);
        } while (!input.equals("all"));
    }

    private static String getNameForResult(List<String> names) {
        String input;

        try {
            input = InputView.inputNameForResult();
            Validator.checkNameForResult(names, input);
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getNameForResult(names);
        }
    }

    private static List<Player> getPlayersForResult(String input) {
	    if (input.equals("all")) {
	        return players;
        }
	    return findPlayer(input);
    }

    private static List<Player> findPlayer(String name) {
        List<Player> foundresult = new ArrayList<>();

	    for (Player player : players) {
            if (player.matchName(name)) {
                foundresult.add(player);
                break;
            }
        }
	    return foundresult;
    }
}
