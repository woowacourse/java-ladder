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

		for (boolean point : line.getPoints()) {
			steps.add((point) ? UserOutput.LADDER_STEP.getOutputMessage()
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

	public static void printPlayerNames(List<Player> players) {
		for(Player player : players) {
			System.out.printf(UserOutput.PRINT_FORM.getOutputMessage(), player.toString());
		}
	}

	public static void printResult(List<Result> results, String name) {
		if(name.equals(UserOutput.PRINT_ALL_PLAYER.getOutputMessage())) {
			for(Result result : results) {
				System.out.println(result.getPlayer() + " : " + result.getReward());
			}
			return;
		}

		for(Result result : results) {
			if(result.getPlayer().matchName(name)) {
				System.out.println(result.getPlayer() + " : " + result.getReward());
				break;
			}
		}
	}
}
