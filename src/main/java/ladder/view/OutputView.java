package ladder.view;

import ladder.domain.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
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

	public static void printLadderGameRewards(List<Reward> rewards) {
		for (Reward reward : rewards) {
			System.out.printf(UserOutput.PRINT_FORM.getOutputMessage(), reward);
		}
		System.out.println();
	}

	public static void printPlayerNames(List<Player> players) {
		for (Player player : players) {
			System.out.printf(UserOutput.PRINT_FORM.getOutputMessage(), player);
		}
		System.out.println();
	}

	public static void printLadderGameResult(LadderGameResult ladderGameResult, String name) {
		if (name.equals(UserOutput.PRINT_ALL_PLAYER.getOutputMessage())) {
			ladderGameResult.getAllPlayerNames().stream()
					.forEach(playerName -> System.out.println(playerName + " : " + ladderGameResult.getReward(playerName)));
			return;
		}

		if (StringUtils.isBlank(name)) {
			return;
		}

		Reward playerReward = ladderGameResult.getReward(new Player(name));
		if (playerReward != null) {
			System.out.println(name + " : " + playerReward);
		}
	}
}
