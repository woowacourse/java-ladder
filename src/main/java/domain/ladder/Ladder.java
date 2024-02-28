package domain.ladder;

import java.util.ArrayList;
import java.util.List;

import dto.FloorConnectionStatusDto;
import generator.LadderFloorGenerator;

public class Ladder {

	private final List<Floor> floors;

	private Ladder(int playerCount, int height) {
		this.floors = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			floors.add(new Floor(playerCount));
		}
	}

	public static Ladder of(int playerCount, int height) {
		return new Ladder(playerCount, height);
	}

	public void drawLines(LadderFloorGenerator generator) {
		floors.forEach(floor -> floor.createCrossingLines(generator));
	}

	public List<FloorConnectionStatusDto> createStatuses() {
		return floors.stream()
			.map(Floor::createFloorConnectionStatus)
			.toList();
	}

	public List<Floor> getFloors() {
		return floors;
	}
}