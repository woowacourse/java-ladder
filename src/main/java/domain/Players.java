package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Players {

	private final List<Player> players;

	public Players(List<Player> players) {
		this.players = players;
	}

	public Player findPlayerFromName(String name) {
		return players.stream()
			.filter(player -> name.equals(player.getName()))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어입니다."));
	}

	public List<String> getPlayerNames() {
		return players.stream()
			.map(Player::getName)
			.toList();
	}

	public Map<String, String> playGhostLeg(Ladder ladder) {
		Map<String, String> playerPrizeMap = new LinkedHashMap<>();
		players.forEach(player -> playerPrizeMap.put(player.getName(), ladder.play(player).getName()));

		return playerPrizeMap;
	}

	public int getPlayerCount() {
		return players.size();
	}
}
