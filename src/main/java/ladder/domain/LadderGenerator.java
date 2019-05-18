package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
	public static Ladder generateLadder(int countOfPerson, String ladderHeight) {
		validateCountOfPerson(countOfPerson);
		validateLadderHeight(ladderHeight);
		return createLadder(countOfPerson, Integer.parseInt(ladderHeight));
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

	private static Ladder createLadder(int countOfPerson, int ladderHegiht) {
		List<Line> lines = new ArrayList<>();

		for (int i = 0; i < ladderHegiht; i++) {
			lines.add(createLine(countOfPerson));
		}
		return new Ladder(lines);
	}

	public static Line createLine(int countOfPerson) {
		List<Point> points = new ArrayList<>();

		points.add(Point.first());

		for (int i = 1; i < countOfPerson - 1; i++) {
			points.add(Point.next(points.get(i-1).canGoRight()));
		}
		points.add(Point.last(points.get(countOfPerson-2).canGoRight()));

		return new Line(points);
	}
}
