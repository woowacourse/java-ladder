package laddergame.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LadderGame {
    private static final String NO_SAME_COUNT_PLAYERS_ITEMS = "참여자 수와 실행 결과 수가 같아야 합니다.";
    private final Players players;
    private final Ladder ladder;
    private final List<ResultItem> items;

    public LadderGame(final Players players, final Ladder ladder, final List<String> items) {
        this.players = players;
        this.ladder = ladder;
        validate(items);
        this.items = items.stream().map(ResultItem::new).toList();
    }

    private void validate(List<String> items) {
        if (items.size() != players.getPlayersCount()) {
            throw new IllegalArgumentException(NO_SAME_COUNT_PLAYERS_ITEMS);
        }
    }

    public void climb() {
        for (Player player : players.getPlayers()) {
            moveToLadderEnd(ladder.move(player.getPosition()), player);
        }
    }

    private void moveToLadderEnd(Direction direction, Player player) {
        while (direction != Direction.END) {
            direction = ladder.move(player.getPosition());
            player.moveLine(direction);
        }
    }

    public void calculatePlayersItem() {
        for (Player player : players.getPlayers()) {
            player.assignItem(items.get(player.getPosition().getX()));
        }
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
