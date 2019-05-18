package ladder.view;

import ladder.domain.*;

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

	public static void printLadderValues(List<String> values) {
		for (String value : values) {
			System.out.printf(UserOutput.PRINT_FORM.getOutputMessage(), value);
		}
		System.out.println();
	}

	public static void printPlayerNames(List<String> players) {
		for (String player : players) {
			System.out.printf(UserOutput.PRINT_FORM.getOutputMessage(), player);
		}
		System.out.println();
	}

	public static void printResult(LadderGameResult ladderGameResult, String name) {
		if (name.equals(UserOutput.PRINT_ALL_PLAYER.getOutputMessage())) {
			// TODO : depth 2 줄이기.
			for (String playerName : ladderGameResult.getAllPlayerNames()) {
				System.out.println(playerName + " : " + ladderGameResult.getReward(playerName));
			}
			return;
		}

		String playerReward = ladderGameResult.getReward(name);
		if (playerReward != null) {
			System.out.println(name + " : " + playerReward);
		}
	}
}
