package ladder;

import java.util.List;
import java.util.stream.Collectors;

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
		OutputView.printLadderGameRewards(ladderGameInformation.getRewards());

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

	public static List<Player> getPersonNames() {
		try {
			return StringSplitUtils.splitString(InputView.inputNames()).stream()
					.map(Player::new)
					.collect(Collectors.toList())
			;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getPersonNames();
		}
	}

	public static List<Reward> getGameReward() {
		return StringSplitUtils.splitString(InputView.inputNames()).stream()
				.map(Reward::new)
				.collect(Collectors.toList())
				;
	}

	public static Ladder generateLadder(int numberOfPlayers) {
		try {
			return Ladder.generateLadder(numberOfPlayers, InputView.inputHeight());
		} catch (Exception e) {
			return generateLadder(numberOfPlayers);
		}
	}

	public static void getPersonNameForGameResult(LadderGameResult ladderGameResult) {
		String name;
		do {
			name = InputView.inputResult();
			OutputView.printLadderGameResult(ladderGameResult, name);
		}
		while (!name.equals(UserOutput.FINISH_LADDER_GAME.getOutputMessage()));
	}
}

