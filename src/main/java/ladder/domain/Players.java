package ladder.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Players implements Iterable<Player> {
    private final List<Player> players;

    public Players(final List<String> names) {
        players = Collections.unmodifiableList(names.stream().map(name -> new Player(name)).collect(Collectors.toList()));
    }

    public boolean hasSameSize(int size) {
        return players.size() == size;
    }

    public int getPlayerSize() {
        return players.size();
    }

    Player getPlayer(int index) {
        return players.get(index);
    }

    @Override
    public Iterator<Player> iterator() {
        return new Iterator<Player>() {
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < players.size();
            }

            @Override
            public Player next() {
                return players.get(count++);
            }
        };
    }
}