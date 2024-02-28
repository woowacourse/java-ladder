package domain;

import domain.ladder.Ladder;
import domain.ladder.common.Direction;
import domain.player.Name;
import domain.player.Player;
import domain.player.Players;

import java.util.stream.Stream;

public class GameBoard {
    private final Players players;
    private final Ladder ladder;
    private final Rewards rewards;

    public GameBoard(Players players, Ladder ladder, Rewards rewards) {
        this.players = players;
        this.ladder = ladder;
        this.rewards = rewards;
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

    public Player findPlayerWithName(Name name) {
        return players.getPlayerWithName(name);
    }

    public Result playGameOnePlayer(Player player) {
        Point startPoint = getPlayerStartPoint(player);
        Point endPoint = playGameWithStartPoint(startPoint);
        return new Result(player.getName(), getRewardWithIndex(endPoint.row()));
    }

    private Point playGameWithStartPoint(final Point startPoint) {
        return Stream.iterate(startPoint, this::movePoint)
                     .filter(this::isPointIsEndLine)
                     .findFirst()
                     .get();
    }

    private Point movePoint(Point point) {
        Direction direction = ladder.getDirectionWithPoint(point);
        return point.move(direction);
    }

    private boolean isPointIsEndLine(Point point) {
        if (point.column() < ladder.getHeight()) {
            return false;
        }
        return true;
    }

    private Point getPlayerStartPoint(Player player) {
        return new Point.Builder().column(0)
                                  .row(players.getPlayerIndex(player))
                                  .build();
    }

    private Reward getRewardWithIndex(Integer index) {
        return rewards.getRewardAt(index);
    }
}
