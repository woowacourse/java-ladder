package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
	public static Ladder generateLadder(int countOfPerson, int ladderHegiht) {
		if (countOfPerson <= 0 || ladderHegiht <= 0) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_NAME.getOutputMessage());
		}
		return createLadder(countOfPerson, ladderHegiht);
	}

	private static Ladder createLadder(int countOfPerson, int ladderHegiht) {
		List<Line> lines = new ArrayList<>();

		for (int i = 0; i < ladderHegiht; i++) {
			lines.add(createLine(countOfPerson));
		}
		return new Ladder(lines);
	}

	public static Line createLine(int countOfPerson) {
		List<Boolean> points = new ArrayList<>();

		points.add(RandomGenerator.getNextValue());
		for (int i = 1; i < countOfPerson - 1; i++) {
			points.add(RandomGenerator.getNextValue(points.get(i - 1)));
		}
		return new Line(points);
	}
}
