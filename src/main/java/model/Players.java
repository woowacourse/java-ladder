package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String NO_PLAYER_NAME_ERROR = "[ERROR] 해당 이름의 플레이어는 존재하지 않습니다.";
    private final List<Player> players = new ArrayList<>();

    public Players(List<Name> names) {
        names.stream()
                .map(Player::new)
                .forEach(players::add);
    }

    public int size() {
        return players.size();
    }

    public List<String> getAllPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public Player findPlayerByName(Name name) {
        return players.stream()
                .filter(player -> player.isPlayerName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_PLAYER_NAME_ERROR));
    }
}
