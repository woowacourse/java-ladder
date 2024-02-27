package domain.player;

import java.util.List;

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

	public List<Player> getPlayers() {
		return players;
	}

	public int getPlayerCount() {
		return players.size();
	}
}