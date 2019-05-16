package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
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
			steps.add((point) ? UserOutput.LADDER_STEP.getOutputMessage() : UserOutput.LADDER_SPACE.getOutputMessage());
		}

		System.out.println(UserOutput.LADDER_LINE.getOutputMessage()+
				String.join(UserOutput.LADDER_LINE.getOutputMessage(), steps) + UserOutput.LADDER_LINE.getOutputMessage());
	}
}
