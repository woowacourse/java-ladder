package ladder;

import java.util.ArrayList;
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
		while (!name.equals(UserOutput.FINISH_LADDER_GAME.getOutputMessage()));
	}

	public static List<Player> getPersonNames() {
		try {
			List<Player> players = new ArrayList<>();
			StringSplitUtils.splitString(InputView.inputNames()).forEach(name -> players.add(new Player(name)));
			return players;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getPersonNames();
		}
	}

	public static List<Reward> getGameReward() {
		List<Reward> rewards = new ArrayList<>();
		StringSplitUtils.splitString(InputView.inputResults()).forEach(reward -> rewards.add(new Reward(reward)));
		return rewards;
	}

	public static Ladder generateLadder(int numberOfPlayers) {
		try {
			return Ladder.generateLadder(numberOfPlayers, InputView.inputHeight());
		} catch (Exception e) {
			return generateLadder(numberOfPlayers);
		}
	}
}

