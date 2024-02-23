package domain;

import java.util.ArrayList;
import java.util.List;

import generator.LadderFloorGenerator;

public class HorizontalLine {

	private static final int MIN_PLAYER_COUNT = 2;
	private static final int MAX_PLAYER_COUNT = 10;

	private final int playerCount;
	private final List<Boolean> floor = new ArrayList<>();

	public HorizontalLine(int playerCount) {
		validatePlayerCount(playerCount);
		this.playerCount = playerCount;
	}

	public void createCrossingLines(LadderFloorGenerator floorGenerator) {
		List<Boolean> generatedFloor = floorGenerator.generate(playerCount - 1);
		floor.addAll(generatedFloor);
	}

	public HorizontalLineStatus createStatus() {
		List<Boolean> placeStatuses = List.copyOf(floor);
		return new HorizontalLineStatus(placeStatuses);
	}

	private void validatePlayerCount(int playerCount) {
		if (playerCount < MIN_PLAYER_COUNT || playerCount > MAX_PLAYER_COUNT) {
			throw new IllegalArgumentException("플레이어 수 범위는 2 이상 10 이하여야 합니다.");
		}
	}
}
