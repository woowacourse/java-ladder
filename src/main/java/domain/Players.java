package domain;

import domain.lines.Lines;

import java.util.List;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;

    public Players(Names names) {
        this.players = createPlayers(names);
    }

    private List<Player> createPlayers(Names names) {
        return IntStream.range(0, names.size()).mapToObj(i -> new Player(names.getNames().get(i), i)).toList();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void playGame(Lines lines) {
        players.forEach(lines::climb);
    }
}
