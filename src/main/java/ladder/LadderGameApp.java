package ladder;

import java.util.Arrays;
import java.util.List;

import ladder.domain.*;
import ladder.util.StringSplitUtils;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameApp {
	public static void main(String[] args) {
		LadderGameInformation ladderGameInformation = getLadderGameInformation();

		Ladder ladder = generateLadder(ladderGameInformation.getPlayers().size());
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
		try {
			return StringSplitUtils.splitString(InputView.inputNames());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getPersonNames();
		}
	}

	public static List<String> getGameReward() {
		return Arrays.asList(InputView.inputResults().split(","));
	}

	public static Ladder generateLadder(int numberOfPlayers) {
		try {
			return LadderGenerator.generateLadder(numberOfPlayers, InputView.inputHeight());
		} catch (Exception e) {
			return generateLadder(numberOfPlayers);
		}
	}
}

