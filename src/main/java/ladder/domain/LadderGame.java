package ladder.domain;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;
    private final Items items;

    public LadderGame(Players players, Ladder ladder, Items items) {
        this.players = players;
        this.ladder = ladder;
        this.items = items;
    }

    public GameResult play() {
        players.moveAll(ladder);
        return GameResult.of(players, items);
    }
}
