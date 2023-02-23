package domain;

import domain.util.PointGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

	private final List<Line> lines;

	private Ladder(List<Line> lines) {
		this.lines = lines;
	}

	public static Ladder create(LadderHeight ladderHeight, LadderWidth ladderWidth, PointGenerator pointGenerator) {
		List<Line> lines = new ArrayList<>();
		int height = ladderHeight.getHeight();
		for (int i = 0; i < height; i++) {
			Line line = Line.create(ladderWidth, pointGenerator);
			lines.add(line);
		}
		return new Ladder(lines);
	}

	public void readLines(SequenceSwapper swapper) {
		for (Line line : lines) {
			line.readPoints(swapper);
		}
	}

	public List<Line> getLines() {
		return Collections.unmodifiableList(this.lines);
	}
}
