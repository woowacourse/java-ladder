package domain;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(Names names) {
        this.players = names.getNames().stream()
                .map(name -> new Player(name, createPosition(names, name)))
                .collect(Collectors.toList());
    }

    private Position createPosition(Names names, Name name) {
        return new Position(names.getNames().indexOf(name));
    }

    public Player findByIndex(int index) {
        return players.get(index);
    }

    public Player findByName(String readPlayer) {
        return players.stream()
                .filter(player -> Objects.equals(player.getName(), new Name(readPlayer)))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 플레이어가 없습니다."));
    }

    public void moveAllPlayers(Lines lines) {
        players.forEach(player -> player.move(lines));
    }

    public List<Player> getPlayersSortedByPosition() {
        return players.stream()
                .sorted(Comparator.comparing(player -> player.getPosition().getPosition()))
                .collect(Collectors.toUnmodifiableList());
    }
}
