package domain.player;

import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(PlayerNames playerNames) {
        this.players = playerNames.getValue()
                .stream()
                .map(Player::new)
                .toList();
    }

    public Player searchPlayer(PlayerName targetPlayerPlayerName) {
        return players.stream()
                .filter(player -> player.hasSamePlayerName(targetPlayerPlayerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어입니다."));
    }

    public PlayerName getPlayerNameAtStartingIndex(int value) {
        return getPlayerNames().get(value);
    }

    public List<PlayerName> getPlayerNames() {
        return players.stream()
                .map(Player::playerName)
                .toList();
    }

    public int getPlayerCount() {
        return players.size();
    }

}
