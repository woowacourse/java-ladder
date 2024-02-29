package domain.ladder;

import java.util.List;

import domain.player.Player;
import dto.FloorConnectionStatusDto;

public class Floor {

	private final List<Bar> bars;

	public Floor(List<Bar> bars) {
		this.bars = bars;
	}

	public void movePlayer(Player player) {
		Bar bar = bars.get(player.getPosition());
		if (bar.isConnectedToRight()) {
			player.moveRight();
			return;
		}
		if (bar.isConnectedToLeft()) {
			player.moveLeft();
		}
	}

	public FloorConnectionStatusDto createFloorConnectionStatus() {
		// 오른쪽으로 연결된 막대만 true로 매핑한뒤, 이를 이용하여 사다리 연결선을 그린다.
		List<Boolean> connectionStatus = bars.stream()
			.map(Bar::isConnectedToRight)
			.toList();

		return new FloorConnectionStatusDto(connectionStatus);
	}
}
