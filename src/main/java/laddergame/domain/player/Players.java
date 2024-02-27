package laddergame.domain.player;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Players {

    private final List<Player> players;

    public Players(final List<String> input) {
        final List<Player> names = convertToPlayers(input);
        validateDuplication(names);

        this.players = names;
    }

    private List<Player> convertToPlayers(final List<String> input) {
        return input.stream()
                .map(Player::new)
                .toList();
    }

    private void validateDuplication(final List<Player> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException("[ERROR] 이름은 중복 될 수 없습니다.");
        }
    }

    public int getSize() {
        return players.size();
    }

    public String getPlayerName(int index) {
        return players.get(index).getName();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public Player findByName(final String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 참가자이름입니다."));
    }
}
