package domain.ladder;

import java.util.ArrayList;
import java.util.List;

import dto.FloorConnectionStatusDto;
import generator.LadderFloorGenerator;

public class Ladder {

	private final List<Floor> lines;

	private Ladder(int playerCount, int height) {
		this.lines = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			lines.add(new Floor(playerCount));
		}
	}

	public static Ladder of(int playerCount, int height) {
		return new Ladder(playerCount, height);
	}

	public void drawLines(LadderFloorGenerator generator) {
		lines.forEach(line -> line.createCrossingLines(generator));
	}

	public List<FloorConnectionStatusDto> createStatuses() {
		return lines.stream()
			.map(Floor::createStatus)
			.toList();
	}

	public List<Floor> getLines() {
		return lines;
	}
}