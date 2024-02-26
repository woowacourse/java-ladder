package laddergame.domain.player;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Players {

    private final List<Player> players;

    public Players(final List<String> input) {
        final List<Player> names = convertToNames(input);
        validateDuplication(names);

        this.players = names;
    }

    private List<Player> convertToNames(final List<String> input) {
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

    public Player getName(int index) {
        return this.players.get(index);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<Player> find(final String input) {
        if (input.equals("all")) {
            return players;
        }

        return List.of(findOne(input));
    }

    private Player findOne(final String input) {
        return players.stream()
                .filter(player -> player.getName().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 참가자이름입니다."));
    }
}
