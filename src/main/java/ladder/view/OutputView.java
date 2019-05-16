package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.UserOutput;

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
			System.out.printf("%-6s", value);
		}
		System.out.println();
	}

	public static void printResult(String name, List<Player> players, List<String> result) {
		if(name.equals("all")) {
			for(Player player : players) {
				System.out.println(player.getName() + " : " + result.get(player.getPosition()));
			}
			return;
		}

		for(Player player : players) {
			if(player.matchName(name)) {
				System.out.println("실행결과 \n" + result.get(player.getPosition()));
				break;
			}
		}
	}
}
