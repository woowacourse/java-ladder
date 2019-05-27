package ladder;

import java.util.List;
import java.util.stream.Collectors;

import ladder.domain.*;
import ladder.util.StringSplitUtils;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameApp {
	private static final String FINISH_LADDER_GAME = "exit";
	private static List<Player> players;
	private static List<Reward> rewards;

	public static void main(String[] args) {
		LadderGame ladderGame = getLadderGameInformation();

		Ladder ladder = generateLadder(players.size());
		OutputView.printPlayerNames(players);
		OutputView.printLadder(ladder);
		OutputView.printLadderGameRewards(rewards);

		LadderGameResult ladderGameResult = ladderGame.run(ladder);

		getPersonNameForGameResult(ladderGameResult);
	}

	public static LadderGame getLadderGameInformation() {
		try {
			players = getPersonNames();
			rewards = getGameReward();
			return new LadderGame(players, rewards);
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
		return StringSplitUtils.splitString(InputView.inputResults()).stream()
				.map(Reward::new)
				.collect(Collectors.toList())
				;
	}

	public static Ladder generateLadder(int numberOfPlayers) {
		try {
			return Ladder.createLadder(numberOfPlayers, InputView.inputHeight());
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
		while (!name.equals(FINISH_LADDER_GAME));
	}
}

