package ladder.view;

import ladder.domain.*;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class OutputView {
	public static final String PRINT_ALL_PLAYER = "all";

	public static void printLadder(Ladder ladder) {
		for (Line line : ladder.getLines()) {
			printLine(line);
		}
	}

	private static void printLine(Line line) {
		List<String> steps = new ArrayList<>();

		for (int i = 0; i < line.getPoints().size() - 1; i++) {
			steps.add((line.getPoints().get(i).canGoRight()) ? UserOutput.LADDER_STEP.getOutputMessage()
					: UserOutput.LADDER_SPACE.getOutputMessage());
		}

		System.out.println(UserOutput.LADDER_LINE.getOutputMessage() +
				String.join(UserOutput.LADDER_LINE.getOutputMessage(), steps)
				+ UserOutput.LADDER_LINE.getOutputMessage());
	}

	public static void printLadderGameRewards(Rewards rewards) {
		for (Reward reward : rewards.getRewards()) {
			System.out.printf(UserOutput.PRINT_FORM.getOutputMessage(), reward);
		}
		System.out.println();
	}

	public static void printPlayerNames(Players players) {
		for (Player player : players.getPlayers()) {
			System.out.printf(UserOutput.PRINT_FORM.getOutputMessage(), player);
		}
		System.out.println();
	}

	public static void printLadderGameResult(LadderGameResult ladderGameResult, String name) {
		if (StringUtils.isBlank(name)) {
			return;
		}

		if (name.equals(PRINT_ALL_PLAYER)) {
			ladderGameResult.getAllPlayerNames().stream()
					.forEach(playerName -> System.out.println(playerName + " : " + ladderGameResult.getReward(playerName)));
			return;
		}

		Reward playerReward = ladderGameResult.getReward(new Player(name));
		if (playerReward != null) {
			System.out.println(name + " : " + playerReward);
		}
	}
}
