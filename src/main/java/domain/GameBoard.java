package domain;

import domain.ladder.Ladder;
import domain.common.Name;
import domain.player.Player;
import domain.player.Players;
import domain.reward.PlayerResult;
import domain.reward.Result;
import domain.reward.Results;

import java.util.List;

public class GameBoard {
    private static final int COLUMN_START_POSITION = 0;
    private final Players players;
    private final Ladder ladder;
    private final Results results;

    public GameBoard(Players players, Ladder ladder, Results results) {
        this.players = players;
        this.ladder = ladder;
        this.results = results;
    }

    public Player findPlayerWithName(Name name) {
        return players.getPlayerWithName(name);
    }

    public PlayerResult playGameOnePlayer(Player player) {
        Point startPoint = getPlayerStartPoint(player);
        Point endPoint = ladder.traverseLadderFromStartToEnd(startPoint);
        return new PlayerResult(player.getName(), getRewardWithIndex(endPoint.row()));
    }

    public List<PlayerResult> playGameAllPlayer() {
        return players.getPlayers()
                      .stream()
                      .map(this::playGameOnePlayer)
                      .toList();
    }

    private Point getPlayerStartPoint(Player player) {
        return new Point.Builder().column(COLUMN_START_POSITION)
                                  .row(players.getPlayerIndex(player))
                                  .build();
    }

    private Result getRewardWithIndex(Integer index) {
        return results.getRewardAt(index);
    }

    public Players getPlayers() {
        return players;
    }

    public int getLadderHeight() {
        return ladder.getHeight();
    }


    public Results getRewards() {
        return results;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
