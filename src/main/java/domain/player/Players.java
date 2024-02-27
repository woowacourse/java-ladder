package domain.player;

import java.util.List;
import java.util.stream.IntStream;

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

    public int getPlayerIndexWithName(Name name) {
        return IntStream.range(0, players.size())
                        .filter(i -> players.get(i)
                                            .isNameEqual(name))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("없는 플레이어입니다!"));
    }

    public int getPlayerCount() {
        return players.size();
    }


}
