package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
	private List<Line> lines;

	public Ladder(List<Line> lines) {
		this.lines = lines;
	}

	public int getLastPosition(int playerPosition) {
		int lastPosition = playerPosition;
		for (Line line : lines) {
			lastPosition = line.getNextPosition(lastPosition);
		}

		return lastPosition;
	}

	public static Ladder generateLadder(int countOfPerson, String ladderHegiht) {
		validateCountOfPerson(countOfPerson);
		validateLadderHeight(ladderHegiht);

		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < Integer.parseInt(ladderHegiht); i++) {
			lines.add(Line.generateLine(countOfPerson));
		}
		return new Ladder(lines);
	}

	private static void validateCountOfPerson(int countOfPerson) {
		if(countOfPerson < 2) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_NUMBER_OF_PLAYERS.getOutputMessage());
		}
	}

	private static void validateLadderHeight(String ladderHeight) {
		if(!ladderHeight.matches(UserOutput.REGEX_FOR_NUMBER.getOutputMessage())) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_LADDER_HEIGHT.getOutputMessage());
		}

		if(Integer.parseInt(ladderHeight) <= 1) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_LADDER_HEIGHT_LESS_THAN_TWO.getOutputMessage());
		}
	}

	public List<Line> getLines() {
		return Collections.unmodifiableList(this.lines);
	}
}
