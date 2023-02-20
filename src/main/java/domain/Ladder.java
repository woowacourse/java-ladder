package domain;

import domain.util.Display;
import domain.util.PointGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder implements Display {

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

	@Override
	public String format() {
		String ladder = lines.stream()
				.map(Line::format)
				.collect(Collectors.joining(System.lineSeparator()));
		return ladder;
	}
}
