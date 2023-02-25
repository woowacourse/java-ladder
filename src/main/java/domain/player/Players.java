package domain.player;

import domain.ladder.Ladder;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
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

    public void moveAllPlayers(Ladder ladder) {
        players.forEach(player -> player.move(ladder));
    }

    public List<Player> getPlayersSortedByPosition() {
        return players.stream()
                .sorted(Comparator.comparing(player -> player.getPosition().getValue()))
                .collect(Collectors.toUnmodifiableList());
        // TODO: getter 자제, 메세지를 보내자.
    }

    public Player findPlayerByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("해당 사용자를 찾을 수 없습니다."));
    }

    public Player findByIndex(int index) {
        return players.stream()
                .filter(player -> player.getPosition().getValue() == index)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
