package domain.player;

import java.util.List;

public record Players(List<Player> players) {

	private static final int MIN_PLAYER_COUNT = 2;
	private static final int MAX_PLAYER_COUNT = 10;

	public Players {
		validatePlayerCount(players.size());
	}

	public Player findPlayerFromName(String name) {
		return players.stream()
			.filter(player -> name.equals(player.getName()))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어입니다."));
	}

	public List<String> getNames() {
		return players.stream()
			.map(Player::getName)
			.toList();
	}

	public int getPlayerCount() {
		return players.size();
	}

	private void validatePlayerCount(int count) {
		if (count < MIN_PLAYER_COUNT || count > MAX_PLAYER_COUNT) {
			throw new IllegalArgumentException("플레이어 수 범위는 2 이상 10 이하여야 합니다.");
		}
	}
}
