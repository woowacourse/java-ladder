package ladder;

import java.util.Arrays;
import java.util.List;

import ladder.domain.LadderGameResult;
import ladder.domain.UserOutput;
import ladder.util.StringSplitUtils;
import ladder.validator.Validator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameApp {
	public static void main(String[] args) {
		List<String> playerNames = getPersonNames();
		List<String> gameReward = getGameReward(playerNames);
		int ladderHeight = getLadderHeight();

		LadderGame ladderGame = new LadderGame(playerNames);

		OutputView.printPlayerNames(playerNames);
		OutputView.printLadder(ladderGame.generateLadder(ladderHeight));
		OutputView.printLadderValues(gameReward);

		LadderGameResult ladderGameResult = ladderGame.run(gameReward);

		String name;
		do {
			name = InputView.inputResult();
			OutputView.printResult(ladderGameResult, name);
		}
		while (!name.equals(UserOutput.PRINT_ALL_PLAYER.getOutputMessage()));
	}

	public static List<String> getPersonNames() {
		String names;

		try {
			names = InputView.inputNames();
			Validator.validateNamesLength(StringSplitUtils.splitString(names));
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
			Validator.validateNumber(height);
			return Integer.parseInt(height);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getLadderHeight();
		}
	}

	public static List<String> getGameReward(List<String> players) {
		String result;

		try {
			result = InputView.inputResults();
			Validator.compareLength(players, StringSplitUtils.splitString(result));
			return Arrays.asList(result.split(","));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getGameReward(players);
		}
	}
}

