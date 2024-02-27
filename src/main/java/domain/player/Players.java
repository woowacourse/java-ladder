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

    public List<Name> getPlayerNames() {
        return players.stream()
                      .map(Player::getName)
                      .toList();
    }

    public Player getPlayerWithName(Name name) {
        return players.stream()
                      .filter(player -> player.isNameEqual(name))
                      .findAny()
                      .orElseThrow(() -> new IllegalArgumentException("없는 플레이어입니다!"));
    }

    public int getPlayerCount() {
        return players.size();
    }


}
