package laddergame.domain.ladder;

import java.util.LinkedHashMap;
import java.util.Map;
import laddergame.domain.ladder.destination.Item;
import laddergame.domain.players.Name;

public class GameResult {

    private final Map<Name, Item> result;

    public GameResult(Map<Name, Item> result) {
        this.result = result;
    }

    public Item findByPlayerName(String name) {
        return result.get(new Name(name));
    }

    public Map<Name, Item> result() {
        return new LinkedHashMap<>(result);
    }
}
