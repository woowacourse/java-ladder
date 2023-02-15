package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Players {
    private final Map<StartPoint, Player> players;

    public Players(List<String> names) {
        players = new HashMap<>();

        IntStream.range(0, names.size())
                .forEach(index -> players.put(new StartPoint(index), new Player(names.get(index))));
    }

    public String getPlayerName(StartPoint startPoint) {
        return players.get(startPoint).getName();
    }
}
