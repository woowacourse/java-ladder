package domain;

import java.util.ArrayList;
import java.util.List;

import generator.LadderFloorGenerator;

public class Floor {

	private static final int MIN_PLAYER_COUNT = 2;
	private static final int MAX_PLAYER_COUNT = 10;

	private final int playerCount;
	private final List<Bar> bars = new ArrayList<>();

	public Floor(int playerCount) {
		validatePlayerCount(playerCount);
		this.playerCount = playerCount;
	}

	public void createCrossingLines(LadderFloorGenerator floorGenerator) {
		List<Bar> generatedFloor = floorGenerator.generate(playerCount);
		bars.addAll(generatedFloor);
	}

	public FloorConnectionStatusDto createStatus() {
		// 오른쪽으로 연결된 막대만 true로 매핑한뒤, 이를 이용하여 사다리 연결선을 그린다.
		List<Boolean> connectionStatus = bars.stream()
			.map(Bar::isConnectedToRight)
			.toList();
		return new FloorConnectionStatusDto(connectionStatus);
	}

	private void validatePlayerCount(int playerCount) {
		if (playerCount < MIN_PLAYER_COUNT || playerCount > MAX_PLAYER_COUNT) {
			throw new IllegalArgumentException("플레이어 수 범위는 2 이상 10 이하여야 합니다.");
		}
	}

	public Bar getBar(int index) {
		return bars.get(index);
	}
}