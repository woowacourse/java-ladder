package laddergame.domain;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;
    private final ResultItems items;

    public LadderGame(final Players players, final Ladder ladder, final ResultItems items) {
        this.players = players;
        this.ladder = ladder;
        this.items = items;
    }

    public void climb() {
        for (Player player : players.getPlayers()) {
            while (true) {
                Direction direction = ladder.move(player.getPosition().getX(), player.getPosition().getY());
                player.moveLine(direction);
                if (direction == Direction.END) {
                    break;
                }
            }
        }
    }

    public void calculatePlayersItem() {
        for (Player player : players.getPlayers()) {
            player.assignItem(items.findByIndex(player.getPosition().getX()));
        }
    }
}
