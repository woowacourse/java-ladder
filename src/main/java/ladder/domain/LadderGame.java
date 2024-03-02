package ladder.domain;

import java.util.Map;

public class LadderGame {

    private final Players players;
    private final ResultItems resultItems;
    private final Ladder ladder;
    private final Result result;

    public LadderGame(Players players, ResultItems resultItems, Ladder ladder) {
        this.players = players;
        this.resultItems = resultItems;
        this.ladder = ladder;
        this.result = new Result(players);
    }

    public boolean isInProgress() {
        return result.hasNullValue();
    }

    public Map<Player, ResultItem> execute(String target) {
        if (target.equals("all")) {
            return findAll();
        }
        return findOne(new Player(target));
    }

    private Map<Player, ResultItem> findAll() {
        players.getPlayers().forEach(this::climb);
        return result.getAll();
    }

    private Map<Player, ResultItem> findOne(Player player) {
        climb(player);
        return result.get(player);
    }

    private void climb(Player player) {
        if (result.hasNullValueForKey(player)) {
            Index playerIndex = players.findIndexOfPlayer(player);
            Index resultItemIndex = ladder.climb(playerIndex);
            ResultItem resultItem = resultItems.get(resultItemIndex);
            result.put(player, resultItem);
        }
    }
}
