package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
	private final List<Line> lines;

	private Ladder(List<Line> lines) {
		this.lines = lines;
	}

	public static Ladder of(final int height, final int width, final PointGenerator generator) {
		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			lines.add(new Line(width, generator));
		}
		return new Ladder(lines);
	}

	public List<Integer> getMovedIndex(int width) {
		List<Integer> indicies = getInitialIdx(width);
		for (Line line : lines) {
			indicies = line.moveThroughLine(indicies);
		}
		return indicies;
	}

	private List<Integer> getInitialIdx(final int size) {
		return IntStream.rangeClosed(0, size).boxed().collect(Collectors.toList());
	}

	public List<Line> getLines() {
		return Collections.unmodifiableList(lines);
	}
}
