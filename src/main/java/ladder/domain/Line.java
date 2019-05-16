package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private List<Boolean> points = new ArrayList<>();

	public Line(int countOfPerson) {
		points.add(RandomGenerator.getRandomBoolean());

		for (int i = 1; i < countOfPerson - 1; ++i) {
			points.add(RandomGenerator.getRandomBoolean(points.get(i - 1)));
		}
	}

	public List<Boolean> getPoints() {
		return this.points;
	}

	public int getNextPositon(int position) {
		if (position == 0) {
			return (points.get(position) ? position + 1 : position);
		}

		if (position == points.size()) {
			return (points.get(position - 1) ? position - 1 : position);
		}

		if ((!points.get(position - 1)) && (!points.get(position))) {
			return position;
		}

		return (points.get(position - 1) ? position - 1 : position + 1);
	}
}
