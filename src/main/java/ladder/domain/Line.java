package ladder.domain;

import java.util.List;

public class Line {
	private final List<Boolean> points;

	public Line(List<Boolean> points) {
		validatePoints(points);
		this.points = points;
	}

	private void validatePoints(List<Boolean> points) {
		for (int i = 0; i < points.size() - 2; i++) {
			if(points.get(i) == true && points.get(i+1) == true){
				throw new IllegalArgumentException();
			}
		}
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

	public List<Boolean> getPoints() {
		return this.points;
	}
}
