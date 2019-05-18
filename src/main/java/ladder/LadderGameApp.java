package ladder;

import java.util.Arrays;
import java.util.List;

import ladder.domain.*;
import ladder.util.StringSplitUtils;
import ladder.validator.Validator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameApp {
	public static void main(String[] args) {
		LadderGameInformation ladderGameInformation = getLadderGameInformation();

		Ladder ladder = LadderGenerator.generateLadder(ladderGameInformation.getPlayers().size(), getLadderHeight());

		OutputView.printPlayerNames(ladderGameInformation.getPlayers());
		OutputView.printLadder(ladder);
		OutputView.printLadderValues(ladderGameInformation.getRewards());

		LadderGameResult ladderGameResult = LadderGame.run(ladderGameInformation, ladder);

		getPersonNameForGameResult(ladderGameResult);
	}

	public static LadderGameInformation getLadderGameInformation() {
		try {
			return new LadderGameInformation(getPersonNames(), getGameReward());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getLadderGameInformation();
		}
	}

	public static void getPersonNameForGameResult(LadderGameResult ladderGameResult) {
		String name;
		do {
			name = InputView.inputResult();
			OutputView.printResult(ladderGameResult, name);
		}
		while (!name.equals(UserOutput.PRINT_ALL_PLAYER.getOutputMessage()));
	}

	public static List<String> getPersonNames() {
		List<String> names;

		try {
			names = StringSplitUtils.splitString(InputView.inputNames());
			Validator.validatePlayerNameAll(names);
			Validator.validateNamesLength(names);
			return names;
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
		return Arrays.asList(InputView.inputResults().split(","));
	}
}

