package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
	private final int countOfPerson;

	public LineGenerator(int countOfPerson) {
		if (countOfPerson <= 0) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_NAME.getOutputMessage());
		}
		this.countOfPerson = countOfPerson;
	}

	public Line createLine() {
		List<Boolean> points = new ArrayList<>();

		points.add(RandomGenerator.getNextValue());
		for (int i = 1; i < countOfPerson - 1; i++) {
			points.add(RandomGenerator.getNextValue(points.get(i - 1)));
		}
		return new Line(points);
	}
}
