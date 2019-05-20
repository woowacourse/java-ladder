package ladder.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ladder.domain.tag.Tag;

public class GameResult implements Iterable<Map.Entry<Tag, Tag>> {
    private static final String GET_ONE_PLAYER_ERROR = "일치하는 플레이어 이름이 없습니다.";

    private Map<Tag, Tag> gameResult;

    public GameResult() {
        gameResult = new HashMap<>();
    }

    public void put(Tag name, Tag result) {
        gameResult.put(name, result);
    }

    public Tag get(Tag name) {
        validName(name);
        return gameResult.get(name);
    }

    private void validName(Tag name) {
        if (gameResult.get(name) == null) {
            throw new IllegalArgumentException(GET_ONE_PLAYER_ERROR);
        }
    }

    @Override
    public Iterator<Map.Entry<Tag, Tag>> iterator() {
        return gameResult.entrySet().iterator();
    }
}