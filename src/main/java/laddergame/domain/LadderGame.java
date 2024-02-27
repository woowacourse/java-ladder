package laddergame.domain;

import java.util.List;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;

    public LadderGame(final Players players, final Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public void start() {
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
}
