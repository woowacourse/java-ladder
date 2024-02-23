package domain;

import java.util.ArrayList;
import java.util.List;

import generator.LadderFloorGenerator;

public class Ladder {

	private final List<HorizontalLine> lines = new ArrayList<>();

	private Ladder(int playerCount, int height) {
		for (int i = 0; i < height; i++) {
			lines.add(new HorizontalLine(playerCount));
		}
	}

	public static Ladder of(int playerCount, int height) {
		return new Ladder(playerCount, height);
	}

	public void drawLines(LadderFloorGenerator generator) {
		lines.forEach(line -> line.createCrossingLines(generator));
	}

	public List<HorizontalLineStatus> createStatuses() {
		return lines.stream()
			.map(HorizontalLine::createStatus)
			.toList();
	}
}
