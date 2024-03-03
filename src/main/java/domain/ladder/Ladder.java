package domain.ladder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import domain.player.Player;
import domain.player.Players;
import domain.prize.Prizes;
import dto.FloorConnectionStatusDto;

public class Ladder {

	private final List<Floor> floors;

	public Ladder(List<Floor> floors) {
		this.floors = floors;
	}

	public Map<String, String> getAllPlayerPrizes(Players players, Prizes prizes) {
		Map<String, String> results = new LinkedHashMap<>();
		for (Player player : players.players()) {
			String result = getOnePlayerPrize(player, prizes);
			results.put(player.getName(), result);
		}
		return results;
	}

	public String getOnePlayerPrize(Player player, Prizes prizes) {
		playLadder(player);
		return prizes.getPlayersPrizeName(player.getPosition());
	}

	public List<FloorConnectionStatusDto> createLadderConnectionStatus() {
		return floors.stream()
			.map(Floor::createFloorConnectionStatus)
			.toList();
	}

	private void playLadder(Player player) {
		floors.forEach(floor -> floor.movePlayer(player));
	}
}
