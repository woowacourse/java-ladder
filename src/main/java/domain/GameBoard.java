package domain;

import domain.ladder.Ladder;
import domain.ladder.attribute.Direction;
import domain.common.Name;
import domain.player.Player;
import domain.player.Players;
import domain.reward.Result;
import domain.reward.Reward;
import domain.reward.Rewards;

import java.util.List;
import java.util.stream.Stream;

public class GameBoard {
    private static final int COLUMN_START_POSITION = 0;
    private final Players players;
    private final Ladder ladder;
    private final Rewards rewards;

    public GameBoard(Players players, Ladder ladder, Rewards rewards) {
        this.players = players;
        this.ladder = ladder;
        this.rewards = rewards;
    }

    public Player findPlayerWithName(Name name) {
        return players.getPlayerWithName(name);
    }

    public Result playGameOnePlayer(Player player) {
        Point startPoint = getPlayerStartPoint(player);
        Point endPoint = ladder.traverseLadderFromStartToEnd(startPoint);
        return new Result(player.getName(), getRewardWithIndex(endPoint.row()));
    }

    public List<Result> playGameAllPlayer() {
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

    private Reward getRewardWithIndex(Integer index) {
        return rewards.getRewardAt(index);
    }

    public Players getPlayers() {
        return players;
    }

    public int getLadderHeight() {
        return ladder.getHeight();
    }


    public Rewards getRewards() {
        return rewards;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
