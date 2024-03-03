package domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;

    public Players(Names names) {
        this.players = createPlayers(names);
    }

    private List<Player> createPlayers(Names names) {
        return IntStream.range(0, names.size())
                .mapToObj(i -> new Player(names.getNames().get(i), i))
                .toList();
    }

    public void playGame(Lines lines) {
        players.forEach(lines::moveDown);
    }

    public Player findByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name)).findAny()
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 이름입니다."));
    }

    public List<Player> getPlayers() {
        return players;
    }
}
