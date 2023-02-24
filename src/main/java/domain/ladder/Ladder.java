package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.util.LinePointsGenerator;
import domain.util.PointGenerator;

public class Ladder {
	private final List<Line> lines;
	private final LadderHeight height;
	private final LadderWidth width;

	public Ladder(final LadderHeight ladderHeight,
		final LadderWidth ladderWidth,
		final PointGenerator pointGenerator) {

		this.lines = new ArrayList<>();
		this.height = ladderHeight;
		this.width = ladderWidth;

		LinePointsGenerator linePointsGenerator = new LinePointsGenerator(ladderWidth.getWidth(), pointGenerator);
		int height = ladderHeight.getHeight();
		for (int i = 0; i < height; i++) {
			lines.add(new Line(linePointsGenerator));
		}
	}

	public int getWidth() {
		return width.getWidth();
	}

	public List<Line> getLines() {
		return Collections.unmodifiableList(lines);
	}
}
