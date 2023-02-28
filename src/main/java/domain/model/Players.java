package domain.model;

import domain.vo.Name;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final String NO_PLAYER_ERROR_MESSAGE = "해당 이름의 플레이어는 존재하지 않습니다.";

    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = List.copyOf(players);
    }

    public static Players from(final List<String> players) {
        Players p = new Players(toPlayer(players));
        p.initPosition();
        return p;
    }

    private static List<Player> toPlayer(final List<String> input) {
        return input.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public void initPosition() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).initPosition(i);
        }
    }

    public void moveAll(final Ladder ladder) {
        players.forEach(player -> player.move(ladder));
    }

    public int orderByName(final String name) {
        return players.stream()
                .filter(player -> player.getName().getValue().equals(name))
                .map(Player::getXPosition)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NO_PLAYER_ERROR_MESSAGE));
    }

    public List<String> nameToString() {
        return players.stream()
                .map(Player::getName)
                .map(Name::getValue)
                .collect(Collectors.toList());
    }

    public boolean containsAll(List<String> names) {
        return new HashSet<>(nameToString()).containsAll(names);

    }
}
