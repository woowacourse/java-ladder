package domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    public static final int NUMBER_OF_MINIMUM_PLAYERS = 2;
    private final List<Player> players;

    public Players(List<Player> players) {
        validateNumberOfPlayer(players);
        validateDuplicate(players);
        this.players = players;
    }

    private void validateNumberOfPlayer(List<Player> players) {
        if (players.size() < NUMBER_OF_MINIMUM_PLAYERS) {
            throw new IllegalArgumentException("플레이어는 두 명 이상이어야 합니다.");
        }
    }

    private void validateDuplicate(List<Player> players) {
        Set<Name> names = players.stream().map(Player::name).collect(Collectors.toSet());
        if (names.size() != players.size()) {
            throw new IllegalArgumentException("플레이어의 이름은 중복될 수 없습니다.");
        }
    }

    public Player getPlayerByName(String inputName) {
        return players.stream().filter(player -> player.name().value().equals(inputName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("플레이어 목록에 존재하지 않는 이름입니다."));
    }

    public Stream<Player> stream() {
        return players.stream();
    }

    public int size() {
        return players.size();
    }
}
