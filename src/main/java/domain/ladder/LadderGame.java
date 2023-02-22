package domain.ladder;

import domain.Command;
import domain.Direction;
import domain.Player;
import domain.Players;
import domain.Point;
import domain.Result;
import domain.Rewards;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final Rewards rewards;

    public LadderGame(Ladder ladder, Players players, Rewards rewards) {
        this.ladder = ladder;
        this.players = players;
        this.rewards = rewards;
        gameStart();
    }

    public void gameStart() {
        players.getPlayers()
                .forEach(this::moveEachPlayer);
    }

    private void moveEachPlayer(Player player) {
        int playerHeight = 0;

        while (playerHeight != ladder.getHeightSize()) {
            move(player, playerHeight);
            playerHeight++;
        }
    }

    private void move(Player player, int playerHeight) {
        int standingLine = player.getStandingLine();
        Point point = ladder.getPoint(playerHeight, standingLine);

        if (point.matchDirection(Direction.LEFT_DOWN)) {
            player.moveLeft();
        }

        if (point.matchDirection(Direction.RIGHT_DOWN)) {
            player.moveRight();
        }
    }

    public List<Result> getResults(Command command) {
        return players.getPlayers()
                .stream()
                .filter(player -> isIncludedInTheResult(command, player))
                .map(this::createResult)
                .collect(Collectors.toList());
    }

    private boolean isIncludedInTheResult(Command command, Player player) {
        if (command.isAllCommand()) {
            return true;
        }

        return command.isCommandMatches(player);
    }

    private Result createResult(Player player) {
        return new Result(player, rewards.getRewards()
                .get(player.getStandingLine())
        );
    }
}
