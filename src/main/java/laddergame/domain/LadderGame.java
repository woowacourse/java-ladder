package laddergame.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private static final String NO_SAME_COUNT_PLAYERS_ITEMS = "참여자 수와 실행 결과 수가 같아야 합니다.";

    private final Players players;
    private final Ladder ladder;
    private final List<ResultItem> items;

    public LadderGame(final Players players, final Ladder ladder, final List<String> items) {
        validate(items, players.getPlayersCount());
        this.players = players;
        this.ladder = ladder;
        this.items = items.stream().map(ResultItem::new).toList();
    }

    private void validate(List<String> items, int playersCount) {
        if (items.size() != playersCount) {
            throw new IllegalArgumentException(NO_SAME_COUNT_PLAYERS_ITEMS);
        }
    }

    public PlayersResult climbLadder() {
        Map<Player, ResultItem> playersResult = new HashMap<>();
        for (Player player : players.getPlayers()) {
            ladder.moveToLadderEnd(player);
            playersResult.put(player, items.get(player.getPosition().getX()));
        }
        return new PlayersResult(playersResult);
    }

    public Players getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<ResultItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
