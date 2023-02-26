package laddergame.domain.ladder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import laddergame.domain.ladder.destination.Item;
import laddergame.domain.players.Name;

public class GameResult {

    private final Map<Name, Item> result;

    public GameResult(final Map<Name, Item> result) {
        this.result = result;
    }

    public Item findByPlayerName(final String name) {
        return Optional.ofNullable(result.get(new Name(name)))
                .orElseThrow(() -> new IllegalArgumentException("참여자 정보가 존재하지 않습니다."));
    }

    public Map<Name, Item> result() {
        return new LinkedHashMap<>(result);
    }
}
