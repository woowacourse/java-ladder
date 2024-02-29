package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {

    private final Map<Player, Result> ladderGameResult;

    private LadderGameResult(LadderGameResultBuilder builder) {
        ladderGameResult = new HashMap<>();
        putLadderGameResult(builder);
    }

    private void putLadderGameResult(LadderGameResultBuilder builder) {
        Ladder ladder = builder.ladder;
        List<Player> players = builder.players.getPlayers();
        List<Result> results = builder.results.getResults();

        players.stream()
                .forEach(
                        player -> ladderGameResult.put(player,
                                results.get(ladder.climb(player.getPosition()).getIndex()))
                );
    }

    public Result get(Player player) {
        return ladderGameResult.get(player);
    }

    public static class LadderGameResultBuilder {
        private Ladder ladder;
        private Players players;
        private Results results;

        public LadderGameResult build() {
            return new LadderGameResult(this);
        }

        public LadderGameResultBuilder ladder(Ladder ladder) {
            this.ladder = ladder;
            return this;
        }

        public LadderGameResultBuilder players(Players players) {
            this.players = players;
            return this;
        }

        public LadderGameResultBuilder results(Results results) {
            this.results = results;
            return this;
        }
    }
}
