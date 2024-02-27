package domain.player;

import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(Names names) {
        this.players = names.getValue()
                            .stream()
                            .map(Player::new)
                            .toList();
    }

    public Player searchPlayer(Name targetPlayerName) {
        return players.stream()
                      .filter(player -> player.name()
                                              .equals(targetPlayerName))
                      .findFirst()
                      .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어입니다."));
    }

    public List<Name> getPlayerNames() {
        return players.stream()
                      .map(Player::name)
                      .toList();
    }

    public int getPlayerCount() {
        return players.size();
    }

}
