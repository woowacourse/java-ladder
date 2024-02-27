package domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(final List<Player> players) {
        validate(players);
        this.players = players;
    }

    public static Players from(List<String> players) {
        return new Players(convertToPlayer(players));
    }

    private static List<Player> convertToPlayer(List<String> players) {
        return players.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public Player search(String name) {
        return players.stream()
                .filter(player -> player.isSameName(name))
                .findFirst()
                .orElseThrow(() ->  new IllegalArgumentException("입력한 참가자 중에서만 결과를 조회할 수 있습니다."));
    }

    public int getCount() {
        return players.size();
    }

    private void validate(List<Player> players) {
        if (hasDuplicate(players)) {
            throw new IllegalArgumentException("중복된 참가자를 입력할 수 없습니다.");
        }
    }

    private boolean hasDuplicate(List<Player> players) {
        return Set.copyOf(players).size() != players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
