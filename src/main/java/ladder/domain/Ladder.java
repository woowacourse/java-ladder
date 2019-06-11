package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ladder.view.UserOutput;

public class Ladder {
	private List<Line> lines;

	private Ladder(final List<Line> lines) {
		this.lines = new ArrayList<>(lines);
	}

	public int getLastPosition(int playerPosition) {
		int lastPosition = playerPosition;
		for (Line line : lines) {
			lastPosition = line.getNextPosition(lastPosition);
		}


		return lastPosition;
	}

	public static Ladder createLadder(int countOfPerson, int ladderHeight) {
		validateCountOfPerson(countOfPerson);
		validateLadderHeight(String.valueOf(ladderHeight));

		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < ladderHeight; i++) {
			lines.add(Line.generateLine(countOfPerson));
		}

		return new Ladder(lines);
	}

	private static void validateCountOfPerson(int countOfPerson) {
		if (countOfPerson < 2) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_NUMBER_OF_PLAYERS.getOutputMessage());
		}
	}

	private static void validateLadderHeight(String ladderHeight) {
		if (!ladderHeight.matches(UserOutput.REGEX_FOR_NUMBER.getOutputMessage())) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_LADDER_HEIGHT.getOutputMessage());
		}

		if (Integer.parseInt(ladderHeight) <= 1) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_LADDER_HEIGHT_LESS_THAN_TWO.getOutputMessage());
		}
	}

	public List<Line> getLines() {
		return Collections.unmodifiableList(this.lines);
	}
}
